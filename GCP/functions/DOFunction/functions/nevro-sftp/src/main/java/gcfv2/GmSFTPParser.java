package gcfv2;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class GmSFTPParser implements HttpFunction {

    private static final Logger logger = Logger.getLogger(GmSFTPParser.class.getName());

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        // SFTP configuration
        String strSFTPHost = System.getenv("nevroSFTPHost");
        String strSFTPUser = System.getenv("nevroSFTPUser");
        String sftpPass = System.getenv("nevroSFTPPass");
        String sftpFilePath =System.getenv("nevroSFTPTestPath");
		logger.info("strSFTPHost"+strSFTPHost);
		logger.info("nevroSFTPUser"+nevroSFTPUser);
		logger.info("nevroSFTPPass"+nevroSFTPPass);
		logger.info("nevroSFTPTestPath"+nevroSFTPTestPath);

        logger.info("Request received");

         Map<String, GmShippingEDI> fileContents = new HashMap<String, GmShippingEDI>();
         GmSalesForceJsonUploader gmSalesForceJsonUploader = new GmSalesForceJsonUploader();
        ObjectMapper mapper = new ObjectMapper();
        JSch jsch = new JSch();
        Session session = jsch.getSession(strSFTPUser, strSFTPHost, 22);
        session.setPassword(sftpPass);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.cd(sftpFilePath);

        @SuppressWarnings("unchecked")
        List<ChannelSftp.LsEntry> fileList = channelSftp.ls(".");

        for (ChannelSftp.LsEntry entry : fileList) {
            String fileName = entry.getFilename();
            if (!entry.getAttrs().isDir()
                    && !fileName.equals(".")
                    && !fileName.equals("..")
                    && fileName.endsWith(".json")) {

                InputStream inputStream = null;
                try {
                    inputStream = channelSftp.get(fileName);
                    GmShippingEDI gmShippingEDI = mapper.readValue(inputStream, GmShippingEDI.class);
                    fileContents.put(gmShippingEDI.getStrRefId(), gmShippingEDI);
                    
                    gmSalesForceJsonUploader.invokeTransition(gmShippingEDI,fileName);
                    logger.info("File parsed from SFTP " + fileName + " EDI " + gmShippingEDI.getStrRefId());
                } catch (Exception e) {
                    logger.info("Error processing file" + fileName);
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            logger.info("Error closing InputStream for file" + fileName);
                        }
                    }
                }
            }
        }

        channelSftp.disconnect();
        session.disconnect();

        response.getWriter().write("Processed"+fileContents+"JSON file(s).");
    }
}
