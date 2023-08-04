package Homework5.models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000;

    private final int id;
        {
            id = ++counter;
        }
    private Date date;
    private String name;

    public int getID() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    
}
