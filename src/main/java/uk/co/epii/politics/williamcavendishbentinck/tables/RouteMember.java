package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;


public class RouteMember {

    private int routeId;
    private String larn;

    public RouteMember () {}
    public RouteMember (int routeId, String larn) {
        this.routeId = routeId;
        this.larn = larn;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getLarn() {
        return larn;
    }

    public void setLarn(String larn) {
        this.larn = larn;
    }

}
