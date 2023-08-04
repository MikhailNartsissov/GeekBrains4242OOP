package Homework5.models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private static int counter;
    private final int id;
        {
            id = ++counter;
        }
    private final Collection<Reservation> reservations = new ArrayList<>();
    public int getId() {
            return id;
    }
    @Override
    public String toString() {
            return String.format("Столик № %d", id);
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }
}
