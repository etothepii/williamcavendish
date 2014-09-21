package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Users {

    private int id;
    private String email;
    private int person;

    public Users () {}
    public Users (int id, String email, int person) {
        this.id = id;
        this.email = email;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

}
