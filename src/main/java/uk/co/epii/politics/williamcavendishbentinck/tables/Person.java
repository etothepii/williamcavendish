package uk.co.epii.politics.williamcavendishbentinck.tables;

import java.sql.Date;
import java.sql.Blob;


public class Person {

    private int id;
    private String surname;
    private String otherNames;
    private String title;
    private String mainContactNumber;

    public Person () {}
    public Person (int id, String surname, String otherNames, String title, String mainContactNumber) {
        this.id = id;
        this.surname = surname;
        this.otherNames = otherNames;
        this.title = title;
        this.mainContactNumber = mainContactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainContactNumber() {
        return mainContactNumber;
    }

    public void setMainContactNumber(String mainContactNumber) {
        this.mainContactNumber = mainContactNumber;
    }

}
