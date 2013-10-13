package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class Dwelling {

    private String voaAddress;
    private String postcode;
    private String councilTaxBand;
    private Long larn;
    private String accessibility;
    private Long uprn;

    public Dwelling () {}
    public Dwelling (String voaAddress, String postcode, String councilTaxBand, Long larn, String accessibility, Long uprn) {
        this.voaAddress = voaAddress;
        this.postcode = postcode;
        this.councilTaxBand = councilTaxBand;
        this.larn = larn;
        this.accessibility = accessibility;
        this.uprn = uprn;
    }

    public String getVoaAddress() {
        return voaAddress;
    }

    public void setVoaAddress(String voaAddress) {
        this.voaAddress = voaAddress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCouncilTaxBand() {
        return councilTaxBand;
    }

    public void setCouncilTaxBand(String councilTaxBand) {
        this.councilTaxBand = councilTaxBand;
    }

    public Long getLarn() {
        return larn;
    }

    public void setLarn(Long larn) {
        this.larn = larn;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public Long getUprn() {
        return uprn;
    }

    public void setUprn(Long uprn) {
        this.uprn = uprn;
    }

}
