package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class RouteMember {

    private int id;
    private String route;
    private long uprn;

    public RouteMember () {}
    public RouteMember (int id, String route, long uprn) {
        this.id = id;
        this.route = route;
        this.uprn = uprn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public long getUprn() {
        return uprn;
    }

    public void setUprn(long uprn) {
        this.uprn = uprn;
    }

}
