package Homework7;

/**
 * Интерфейс рассылки вакансий
 */

public interface Publisher {

    void sendOffer(String companyName, int salary);
    boolean sendVacancy(String companyName, Vacancy vacancy, int salary);
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
