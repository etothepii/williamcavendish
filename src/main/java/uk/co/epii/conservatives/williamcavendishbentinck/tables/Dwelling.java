package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class Dwelling {

    private String voaAddress;
    private String postcode;
    private char councilTaxBand;
    private String larn;
    private Character accessibility;
    private Long uprn;

    public Dwelling () {}
    public Dwelling (String voaAddress, String postcode, char councilTaxBand, String larn, Character accessibility, Long uprn) {
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

    public char getCouncilTaxBand() {
        return councilTaxBand;
    }

    public void setCouncilTaxBand(char councilTaxBand) {
        this.councilTaxBand = councilTaxBand;
    }

    public String getLarn() {
        return larn;
    }

    public void setLarn(String larn) {
        this.larn = larn;
    }

    public Character getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Character accessibility) {
        this.accessibility = accessibility;
    }

    public Long getUprn() {
        return uprn;
    }

    public void setUprn(Long uprn) {
        this.uprn = uprn;
    }

}
