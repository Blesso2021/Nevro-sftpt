package gcfv2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GmShippingEDI {

    @JsonProperty("version")
    private String strVersion;
    @JsonProperty("shippingId")
    private String strShippingId;
    @JsonProperty("source")
    private String strSource;
    @JsonProperty("gloAccountId")
    private String strGloAccountId;
    @JsonProperty("gloAccountNm")
    private String strGloAccountNm;
    @JsonProperty("gloCusPO")
    private String strGloCusPO;
    @JsonProperty("refId")
    private String strRefId;
    @JsonProperty("salesRepId")
    private String strSalesRepId;
    @JsonProperty("salesRepName")
    private String strSalesRepName;
    @JsonProperty("SFSalesRepID")
    private String strSFSalesRepId;
    @JsonProperty("SFAcctID")
    private String strSFAcctId;
    @JsonProperty("SFDistributorID")
    private String strSFDistributorId;
    @JsonProperty("requiredDate")
    private String strRequiredDate;
    @JsonProperty("raFlag")
    private String strRaFlag;
    @JsonProperty("parts")
    private List<GmParts> gmParts;
    @JsonProperty("shippingCharges")
    private String strShippingCharges;
    @JsonProperty("shipTo")
    private String strShipTo;
    @JsonProperty("shipToName")
    private String strShipToName;
    @JsonProperty("shipToDate")
    private String strShipToDate;
    @JsonProperty("deliveryMode")
    private String strDeliveryMode;
    @JsonProperty("deliveryCarrier")
    private String strDeliveryCarrier;
    @JsonProperty("trackingNo")
    private String strTrackingNo;
    @JsonProperty("plannedShippedDate")
    private String strPlannedShippedDate;
    @JsonProperty("shippedDate")
    private String strShippedDate;
    @JsonProperty("statusFl")
    private String strStatusFl;
    @JsonProperty("createdBy")
    private String strCreatedBy;
    @JsonProperty("lastUpdatedBy")
    private String strLastUpdatedBy;
    @JsonProperty("lastUpdatedDate")
    private String strLastUpdatedDate;
    @JsonProperty("shipToAddress")
    private String strShipToAddress;

    // Getters and Setters
    public String getStrShippingId() {
        return strShippingId;
    }

    public void setStrShippingId(String strShippingId) {
        this.strShippingId = strShippingId;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrRefId() {
        return strRefId;
    }

    public void setStrRefId(String strRefId) {
        this.strRefId = strRefId;
    }

    public String getStrSalesRepId() {
        return strSalesRepId;
    }

    public void setStrSalesRepId(String strSalesRepId) {
        this.strSalesRepId = strSalesRepId;
    }

    public String getStrSalesRepName() {
        return strSalesRepName;
    }

    public void setStrSalesRepName(String strSalesRepName) {
        this.strSalesRepName = strSalesRepName;
    }

    public List<GmParts> getGmParts() {
        return gmParts;
    }

    public void setGmParts(List<GmParts> gmParts) {
        this.gmParts = gmParts;
    }

    public String getStrShippingCharges() {
        return strShippingCharges;
    }

    public void setStrShippingCharges(String strShippingCharges) {
        this.strShippingCharges = strShippingCharges;
    }

    public String getStrShipTo() {
        return strShipTo;
    }

    public void setStrShipTo(String strShipTo) {
        this.strShipTo = strShipTo;
    }

    public String getStrShipToName() {
        return strShipToName;
    }

    public void setStrShipToName(String strShipToName) {
        this.strShipToName = strShipToName;
    }

    public String getStrShipToDate() {
        return strShipToDate;
    }

    public void setStrShipToDate(String strShipToDate) {
        this.strShipToDate = strShipToDate;
    }

    public String getStrDeliveryMode() {
        return strDeliveryMode;
    }

    public void setStrDeliveryMode(String strDeliveryMode) {
        this.strDeliveryMode = strDeliveryMode;
    }

    public String getStrDeliveryCarrier() {
        return strDeliveryCarrier;
    }

    public void setStrDeliveryCarrier(String strDeliveryCarrier) {
        this.strDeliveryCarrier = strDeliveryCarrier;
    }

    public String getStrTrackingNo() {
        return strTrackingNo;
    }

    public void setStrTrackingNo(String strTrackingNo) {
        this.strTrackingNo = strTrackingNo;
    }

    public String getStrShippedDate() {
        return strShippedDate;
    }

    public void setStrShippedDate(String strShippedDate) {
        this.strShippedDate = strShippedDate;
    }

    public String getStrStatusFl() {
        return strStatusFl;
    }

    public void setStrStatusFl(String strStatusFl) {
        this.strStatusFl = strStatusFl;
    }

    public String getStrCreatedBy() {
        return strCreatedBy;
    }

    public void setStrCreatedBy(String strCreatedBy) {
        this.strCreatedBy = strCreatedBy;
    }

    public String getStrLastUpdatedBy() {
        return strLastUpdatedBy;
    }

    public void setStrLastUpdatedBy(String strLastUpdatedBy) {
        this.strLastUpdatedBy = strLastUpdatedBy;
    }

    public String getStrLastUpdatedDate() {
        return strLastUpdatedDate;
    }

    public void setStrLastUpdatedDate(String strLastUpdatedDate) {
        this.strLastUpdatedDate = strLastUpdatedDate;
    }

    public String getStrShipToAddress() {
        return strShipToAddress;
    }

    public void setStrShipToAddress(String strShipToAddress) {
        this.strShipToAddress = strShipToAddress;
    }

    public String getStrGloAccountId() {
        return strGloAccountId;
    }

    public void setStrGloAccountId(String strGloAccountId) {
        this.strGloAccountId = strGloAccountId;
    }

    public String getStrGloAccountNm() {
        return strGloAccountNm;
    }

    public void setStrGloAccountNm(String strGloAccountNm) {
        this.strGloAccountNm = strGloAccountNm;
    }

    public String getStrGloCusPO() {
        return strGloCusPO;
    }

    public void setStrGloCusPO(String strGloCusPO) {
        this.strGloCusPO = strGloCusPO;
    }

    public String getStrSFSalesRepId() {
        return strSFSalesRepId;
    }

    public void setStrSFSalesRepId(String strSFSalesRepId) {
        this.strSFSalesRepId = strSFSalesRepId;
    }

    public String getStrSFAcctId() {
        return strSFAcctId;
    }

    public void setStrSFAcctId(String strSFAcctId) {
        this.strSFAcctId = strSFAcctId;
    }

    public String getStrSFDistributorId() {
        return strSFDistributorId;
    }

    public void setStrSFDistributorId(String strSFDistributorId) {
        this.strSFDistributorId = strSFDistributorId;
    }

    public String getStrRequiredDate() {
        return strRequiredDate;
    }

    public void setStrRequiredDate(String strRequiredDate) {
        this.strRequiredDate = strRequiredDate;
    }

    public String getStrRaFlag() {
        return strRaFlag;
    }

    public void setStrRaFlag(String strRaFlag) {
        this.strRaFlag = strRaFlag;
    }

    public String getStrPlannedShippedDate() {
        return strPlannedShippedDate;
    }

    public void setStrPlannedShippedDate(String strPlannedShippedDate) {
        this.strPlannedShippedDate = strPlannedShippedDate;
    }

    public String getStrVersion() {
        return strVersion;
    }

    public void setStrVersion(String strVersion) {
        this.strVersion = strVersion;
    }

    // Static inner classes
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class GmParts {

        @JsonProperty("partNumber")
        private String strPartNumber;
        @JsonProperty("description")
        private String strDescription;
        @JsonProperty("qty")
        private int qty;
        @JsonProperty("lotNumber")
        private String strLotNumber;
        @JsonProperty("serialInfo")
        private List<GmSerialInfo> gmSerialInfo;
        @JsonProperty("pricing")
        private double pricing;

        public String getStrPartNumber() {
            return strPartNumber;
        }

        public void setStrPartNumber(String strPartNumber) {
            this.strPartNumber = strPartNumber;
        }

        public String getStrDescription() {
            return strDescription;
        }

        public void setStrDescription(String strDescription) {
            this.strDescription = strDescription;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getStrLotNumber() {
            return strLotNumber;
        }

        public void setStrLotNumber(String strLotNumber) {
            this.strLotNumber = strLotNumber;
        }

        public List<GmSerialInfo> getGmSerialInfo() {
            return gmSerialInfo;
        }

        public void setGmSerialInfo(List<GmSerialInfo> gmSerialInfo) {
            this.gmSerialInfo = gmSerialInfo;
        }

        /**
         * @return the pricing
         */
        public double getPricing() {
            return pricing;
        }

        /**
         * @param pricing the pricing to set
         */
        public void setPricing(double pricing) {
            this.pricing = pricing;
        }

    }

    public static class GmSerialInfo {

        @JsonProperty("serial")
        private String strSerial;
        @JsonProperty("mfgDate")
        private String strManfDate;
        @JsonProperty("expiryDate")
        private String strExpiryDate;

        public String getStrSerial() {
            return strSerial;
        }

        public void setStrSerial(String strSerial) {
            this.strSerial = strSerial;
        }

        public String getStrManfDate() {
            return strManfDate;
        }

        public void setStrManfDate(String strManfDate) {
            this.strManfDate = strManfDate;
        }

        public String getStrExpiryDate() {
            return strExpiryDate;
        }

        public void setStrExpiryDate(String strExpiryDate) {
            this.strExpiryDate = strExpiryDate;
        }
    }
}
