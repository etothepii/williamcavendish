package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class BoundedArea {

    private int id;
    private Integer parent;
    private Integer owner;
    private Integer ownerGroup;
    private String name;
    private Blob boundary;

    public BoundedArea () {}
    public BoundedArea (int id, Integer parent, Integer owner, Integer ownerGroup, String name, Blob boundary) {
        this.id = id;
        this.parent = parent;
        this.owner = owner;
        this.ownerGroup = ownerGroup;
        this.name = name;
        this.boundary = boundary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getBoundary() {
        return boundary;
    }

    public void setBoundary(Blob boundary) {
        this.boundary = boundary;
    }

}
