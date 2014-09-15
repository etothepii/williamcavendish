package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class BoundedArea {

    private int id;
    private Integer parent;
    private String name;
    private Blob boundary;

    public BoundedArea () {}
    public BoundedArea (int id, Integer parent, String name, Blob boundary) {
        this.id = id;
        this.parent = parent;
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
