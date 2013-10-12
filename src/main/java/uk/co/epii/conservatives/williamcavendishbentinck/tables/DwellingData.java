package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class DwellingData {

    private Long uprn;
    private String councilTaxBand;
    private String accessibility;

    public DwellingData () {}
    public DwellingData (Long uprn, String councilTaxBand, String accessibility) {
        this.uprn = uprn;
        this.councilTaxBand = councilTaxBand;
        this.accessibility = accessibility;
    }

    public Long getUprn() {
        return uprn;
    }

    public void setUprn(Long uprn) {
        this.uprn = uprn;
    }

    public String getCouncilTaxBand() {
        return councilTaxBand;
    }

    public void setCouncilTaxBand(String councilTaxBand) {
        this.councilTaxBand = councilTaxBand;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

}
