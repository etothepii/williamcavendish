package uk.co.epii.conservatives.williamcavendishbentinck.tables;

import java.sql.Date;


public class RouteMember {

    private int routeId;
    private long uprn;

    public RouteMember () {}
    public RouteMember (int routeId, long uprn) {
        this.routeId = routeId;
        this.uprn = uprn;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public long getUprn() {
        return uprn;
    }

    public void setUprn(long uprn) {
        this.uprn = uprn;
    }

}
