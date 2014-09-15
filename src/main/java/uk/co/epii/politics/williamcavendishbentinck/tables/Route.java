package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Route {

    private int id;
    private String name;
    private int boundedArea;
    private Integer deliveredBy;
    private Blob boundary;

    public Route () {}
    public Route (int id, String name, int boundedArea, Integer deliveredBy, Blob boundary) {
        this.id = id;
        this.name = name;
        this.boundedArea = boundedArea;
        this.deliveredBy = deliveredBy;
        this.boundary = boundary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoundedArea() {
        return boundedArea;
    }

    public void setBoundedArea(int boundedArea) {
        this.boundedArea = boundedArea;
    }

    public Integer getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(Integer deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Blob getBoundary() {
        return boundary;
    }

    public void setBoundary(Blob boundary) {
        this.boundary = boundary;
    }

}
