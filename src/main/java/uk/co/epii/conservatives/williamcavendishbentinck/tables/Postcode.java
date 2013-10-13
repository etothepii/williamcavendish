package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class Postcode {

    private String postcode;
    private float XCoordinate;
    private float YCoordinate;

    public Postcode () {}
    public Postcode (String postcode, float XCoordinate, float YCoordinate) {
        this.postcode = postcode;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public float getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(float XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public float getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(float YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

}
