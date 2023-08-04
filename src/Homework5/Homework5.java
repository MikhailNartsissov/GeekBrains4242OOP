package Homework5;

import Homework5.models.TableModel;
import Homework5.presenters.BookingPresenter;
import Homework5.presenters.Model;
import Homework5.presenters.View;
import Homework5.views.BookingView;

import java.util.Date;


public class Homework5 {
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter bookingPresenter = new BookingPresenter(view, model);
        bookingPresenter.showTables();

        int oldReservation = view.reservationTable(new Date(), 3, "Михаил");

        view.changeReservationTable(oldReservation, new Date(), 3, "Станислав");
        }
   }
