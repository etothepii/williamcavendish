package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Route {

    private String id;
    private String name;
    private String boundedArea;
    private Integer owner;
    private Integer ownerGroup;
    private Integer deliveredBy;
    private Blob boundary;

    public Route () {}
    public Route (String id, String name, String boundedArea, Integer owner, Integer ownerGroup, Integer deliveredBy, Blob boundary) {
        this.id = id;
        this.name = name;
        this.boundedArea = boundedArea;
        this.owner = owner;
        this.ownerGroup = ownerGroup;
        this.deliveredBy = deliveredBy;
        this.boundary = boundary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoundedArea() {
        return boundedArea;
    }

    public void setBoundedArea(String boundedArea) {
        this.boundedArea = boundedArea;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getOwnerGroup() {
        return ownerGroup;
    }

    public void setOwnerGroup(Integer ownerGroup) {
        this.ownerGroup = ownerGroup;
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
