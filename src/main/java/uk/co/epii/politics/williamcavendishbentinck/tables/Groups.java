package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Groups {

    private int id;

    public Groups () {}
    public Groups (int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
