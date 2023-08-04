package Homework5.presenters;

import java.util.Date;

public interface ViewObserver {
    int onReservationTable(Date reservationDate, int tableID, String name);
    int onChangeReservationTable(int oldReservationID, Date reservationDate, int tableID, String name);
}
