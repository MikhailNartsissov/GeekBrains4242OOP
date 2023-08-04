package Homework5.models;

import Homework5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                tables.add(new Table());
            }
        }
        return tables;
    }
    public boolean exists (int tableID) {
        for (Table table: loadTables()) {
            if (table.getId() == tableID) {
                return true;
            }
        }
        return false;
    }

    public Table getByID (int tableID) {
        for (Table table: loadTables()) {
            if (table.getId() == tableID) {
                return table;
            }
        }
        return null;
    }
    public int reservationTable(Date reservationDate, int tableID, String name) {
            if (exists(tableID)) {
                Reservation reservation = new Reservation(reservationDate, name);
                getByID(tableID).getReservations().add(reservation);
                return reservation.getID();
            }
        throw new RuntimeException("Вы указали некорректный номер столика. Проверьте введённые данные.");
    }

    public int changeReservationTable(int oldReservationID, Date reservationDate, int tableID, String name) {
        if (exists(tableID)) {
            Table table = getByID(tableID);
            for (Reservation oldReservation: table.getReservations()) {
                if (oldReservation.getID() == oldReservationID) {
                    table.getReservations().remove(oldReservation);
                    Reservation newReservation = new Reservation(reservationDate, name);
                    table.getReservations().add(newReservation);
                    return newReservation.getID();
                }
            }
            throw new RuntimeException("Некорректный номер бронирования. Проверьте введённые данные.");
        }
        throw new RuntimeException("Некорректный номер столика. Проверьте введённые данные.");
    }
}

