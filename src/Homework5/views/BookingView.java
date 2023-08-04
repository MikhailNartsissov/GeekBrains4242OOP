package Homework5.views;

import Homework5.models.Table;
import Homework5.presenters.View;
import Homework5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }
    public void showReservationTableResult(int reservationID) {
        System.out.printf("\n***\nСтолик успешно забронирован. Номер вашей брони #%d\n", reservationID);
    }
    public void showChangeReservationTableResult(int newReservationID, int oldReservationID) {
        System.out.printf("\n***\nБронирование успешно изменено.\nСтарое бронирование под номером #%d аннулировано.\n",
                oldReservationID);
        System.out.printf("Номер нового бронирования #%d\n",newReservationID);
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public int reservationTable(Date reservationDate, int tableID, String name) {
        return observer.onReservationTable(reservationDate, tableID, name);
    }
    public int changeReservationTable(int oldReservationID, Date reservationDate, int tableID, String name) {
        return observer.onChangeReservationTable(oldReservationID, reservationDate, tableID, name);
    }
}
