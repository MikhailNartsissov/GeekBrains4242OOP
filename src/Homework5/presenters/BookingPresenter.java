package Homework5.presenters;

import Homework5.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final View view;
    private final Model model;

    public BookingPresenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setObserver(this);
    }
    private Collection<Table> loadTables() {
        return model.loadTables();
    }
    public void showTables() {
        view.showTables(loadTables());
    }
    private void showReservationTableResult(int reservationID) {
        view.showReservationTableResult(reservationID);
    }
    private void showChangeReservationTableResult(int newReservationID, int oldReservationID) {
        view.showChangeReservationTableResult(newReservationID, oldReservationID);
    }
    @Override
    public int onReservationTable(Date reservationDate, int tableID, String name) {
        int reservationID = model.reservationTable(reservationDate, tableID, name);
        showReservationTableResult(reservationID);
        return reservationID;
    }
    @Override
    public int onChangeReservationTable(int oldReservationID, Date reservationDate, int tableID, String name) {
        int newReservationID = model.changeReservationTable(oldReservationID, reservationDate, tableID, name);
        showChangeReservationTableResult(newReservationID, oldReservationID);
        return newReservationID;
    }
}
