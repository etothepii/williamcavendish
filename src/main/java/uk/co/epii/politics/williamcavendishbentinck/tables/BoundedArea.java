package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class BoundedArea {

    private String id;
    private String parent;
    private Integer owner;
    private Integer ownerGroup;
    private String name;
    private Blob boundary;

    public BoundedArea () {}
    public BoundedArea (String id, String parent, Integer owner, Integer ownerGroup, String name, Blob boundary) {
        this.id = id;
        this.parent = parent;
        this.owner = owner;
        this.ownerGroup = ownerGroup;
        this.name = name;
        this.boundary = boundary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
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
