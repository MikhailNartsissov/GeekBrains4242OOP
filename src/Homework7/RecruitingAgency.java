package Homework7;

import java.util.ArrayList;
import java.util.List;

/**
 * Рекрутинговое агентство
 */

public class RecruitingAgency implements Publisher{

    List<Observer> observers = new ArrayList<>();
    @Override
    public void sendOffer(String companyName, int salary) {
        for (Observer observer: observers) {
            observer.receiveOffer(companyName, salary);
        }

    }

    @Override
    public boolean sendVacancy(String companyName, Vacancy vacancy, int salary) {
        for (Observer observer: observers) {
            boolean b = observer.receiveVacancy(companyName, vacancy, salary);
            if (b){
                removeObserver(observer);
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
}
