package Homework7;

public interface Observer {
    void receiveOffer(String companyName, int salary);
    boolean receiveVacancy(String companyName, Vacancy vacancy, int salary);
}
