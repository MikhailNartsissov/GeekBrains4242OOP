package Homework5.presenters;

import Homework5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {
    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    int reservationTable(Date reservationDate, int tableId, String name);
    int changeReservationTable(int oldReservationID, Date reservationDate, int tableID, String name);
    void showReservationTableResult(int reservationID);
    void showChangeReservationTableResult(int newReservationID, int oldReservationID);
}
