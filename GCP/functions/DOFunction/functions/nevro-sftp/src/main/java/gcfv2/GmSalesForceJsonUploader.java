package gcfv2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class GmSalesForceJsonUploader {

    private static final Logger logger = Logger.getLogger(GmSalesForceJsonUploader.class.getName());

     // === Configuration ===
    private static final String AUTH_URL = System.getenv("nevroAuthURL");
    private static final String JSON_UPLOAD_URL = System.getenv("nevroJUploadURL");
    private static final String CLIENT_ID = System.getenv("nevroClientID");
    private static final String CLIENT_SECRET = System.getenv("nevroClientSecret");

    public void invokeTransition(GmShippingEDI gmShippingEDI,String fileName){
       try {
            String accessToken = getAccessToken();
            if (accessToken != null) {
                uploadJsonFile(accessToken,gmShippingEDI,fileName );
            } else {
                logger.info("Failed to get access token");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // === Get Access Token ===
    private static String getAccessToken() throws IOException {
        URL url = new URL(AUTH_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String data = "grant_type=client_credentials" +
                      "&client_id=" + CLIENT_ID +
                      "&client_secret=" + CLIENT_SECRET;

        try (OutputStream os = conn.getOutputStream()) {
            os.write(data.getBytes());
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            try (InputStream is = conn.getInputStream()) {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode jsonNode = (ObjectNode) mapper.readTree(is);
                return jsonNode.get("access_token").asText();
            }
        } else {
            logger.info("Error fetching access token " + responseCode);
            try (InputStream err = conn.getErrorStream()) {
                if (err != null) {
                    err.transferTo(System.out);
                }
            }
        }
        return null;
    }

    // === Upload JSON File to Salesforce ===
    private static void uploadJsonFile(String accessToken, GmShippingEDI gmShippingEDI,String filename) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Step 1: Convert object to JSON string
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gmShippingEDI);

        // Step 2: Convert JSON string to base64
        String base64EncodedJsonContent= Base64.getEncoder().encodeToString(jsonString.getBytes(StandardCharsets.UTF_8));

        // Convert domain object to a mutable JSON object
        ObjectNode jsonNode = mapper.createObjectNode();

        // Add additional fields
        jsonNode.put("Title", filename);
        jsonNode.put("PathOnClient", filename);
        jsonNode.put("VersionData", base64EncodedJsonContent);  // from your file


        String payloadStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        logger.info( payloadStr);

        URL url = new URL(JSON_UPLOAD_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = conn.getOutputStream()) {
            os.write(payloadStr.getBytes());
        }

        int responseCode = conn.getResponseCode();
        InputStream inputStream = (responseCode < HttpURLConnection.HTTP_BAD_REQUEST)
                ? conn.getInputStream() : conn.getErrorStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            logger.info("Response");
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }
        }
    }
}
