package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class LeafletMap {

    private String id;
    private int leaflet;
    private int route;
    private Date delivered;
    private Integer deliveredBy;

    public LeafletMap () {}
    public LeafletMap (String id, int leaflet, int route, Date delivered, Integer deliveredBy) {
        this.id = id;
        this.leaflet = leaflet;
        this.route = route;
        this.delivered = delivered;
        this.deliveredBy = deliveredBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLeaflet() {
        return leaflet;
    }

    public void setLeaflet(int leaflet) {
        this.leaflet = leaflet;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public Date getDelivered() {
        return delivered;
    }

    public void setDelivered(Date delivered) {
        this.delivered = delivered;
    }

    public Integer getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(Integer deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

}
