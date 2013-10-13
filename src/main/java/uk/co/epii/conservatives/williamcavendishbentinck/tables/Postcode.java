package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class Postcode {

    private String postcode;
    private int accuracy;
    private float XCoordinate;
    private float YCoordinate;

    public Postcode () {}
    public Postcode (String postcode, int accuracy, float XCoordinate, float YCoordinate) {
        this.postcode = postcode;
        this.accuracy = accuracy;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
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
