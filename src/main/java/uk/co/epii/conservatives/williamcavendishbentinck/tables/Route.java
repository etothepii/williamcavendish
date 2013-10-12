package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class Route {

    private int id;
    private String name;
    private Float minX;
    private Float minY;
    private Float maxX;
    private Float maxY;
    private Integer deliveredBy;

    public Route () {}
    public Route (int id, String name, Float minX, Float minY, Float maxX, Float maxY, Integer deliveredBy) {
        this.id = id;
        this.name = name;
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.deliveredBy = deliveredBy;
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

    public Float getMinX() {
        return minX;
    }

    public void setMinX(Float minX) {
        this.minX = minX;
    }

    public Float getMinY() {
        return minY;
    }

    public void setMinY(Float minY) {
        this.minY = minY;
    }

    public Float getMaxX() {
        return maxX;
    }

    public void setMaxX(Float maxX) {
        this.maxX = maxX;
    }

    public Float getMaxY() {
        return maxY;
    }

    public void setMaxY(Float maxY) {
        this.maxY = maxY;
    }

    public Integer getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(Integer deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

}
