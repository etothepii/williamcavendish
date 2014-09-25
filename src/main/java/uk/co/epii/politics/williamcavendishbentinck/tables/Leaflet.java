package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Leaflet {

    private String id;
    private Date deliveryCommenced;
    private String title;
    private String description;

    public Leaflet () {}
    public Leaflet (String id, Date deliveryCommenced, String title, String description) {
        this.id = id;
        this.deliveryCommenced = deliveryCommenced;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDeliveryCommenced() {
        return deliveryCommenced;
    }

    public void setDeliveryCommenced(Date deliveryCommenced) {
        this.deliveryCommenced = deliveryCommenced;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
