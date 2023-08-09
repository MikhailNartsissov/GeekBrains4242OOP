package Homework7;

import java.util.*;

public class Homework7 {
    public static void main(String[] args) {

        Random random = new Random();

        ArrayList<Vacancy> googleVacancies = new ArrayList<>();
        googleVacancies.add(new Vacancy("Engineer", VacancyType.OtherStaff, "Good job"));
        googleVacancies.add(new Vacancy("Java developer", VacancyType.IT, "Great job"));
        googleVacancies.add(new Vacancy("Python developer", VacancyType.IT, "Another one great job"));

        ArrayList<Vacancy> yandexVacancies = new ArrayList<>();
        yandexVacancies.add(new Vacancy("Support Engineer", VacancyType.OtherStaff, "Good job"));
        yandexVacancies.add(new Vacancy("C++ developer", VacancyType.IT, "Great job"));
        yandexVacancies.add(new Vacancy("GoLang developer", VacancyType.IT, "Another one great job"));

        ArrayList<Vacancy> geekBrainsVacancies = new ArrayList<>();
        geekBrainsVacancies.add(new Vacancy("Teacher", VacancyType.OtherStaff, "Good job"));
        geekBrainsVacancies.add(new Vacancy("Django developer", VacancyType.IT, "Great job"));
        geekBrainsVacancies.add(new Vacancy("Marketing manager",
                VacancyType.OtherStaff, "Another one great job"));
        Publisher recruitingAgency = new RecruitingAgency();


        Company google = new Company(recruitingAgency, "Google", 180000);
        google.setVacancies(googleVacancies);
        for (Vacancy vacancy: googleVacancies) {
            System.out.println(vacancy);
            }
        Company yandex = new Company(recruitingAgency, "Yandex", 150000);
        yandex.setVacancies(yandexVacancies);
        Company geekBrains = new Company(recruitingAgency, "GeekBrains", 120000);
        geekBrains.setVacancies(geekBrainsVacancies);
        Student petrov = new Student("Петров");
        petrov.setVacancyType(VacancyType.OtherStaff);
        Middle ivanov = new Middle("Иванов");
        ivanov.setVacancyType(VacancyType.IT);
        Master sidorov = new Master("Сидоров");
        sidorov.setVacancyType(VacancyType.IT);

        recruitingAgency.registerObserver(petrov);
        recruitingAgency.registerObserver(ivanov);
        recruitingAgency.registerObserver(sidorov);

        google.openVacancies();;
        yandex.openVacancies();
        geekBrains.openVacancies();

    }
}
