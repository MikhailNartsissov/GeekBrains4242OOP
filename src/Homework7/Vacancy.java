package Homework7;

public class Vacancy {

    Publisher recruitingAgency;

    public String name;
    public VacancyType vacancyType;
    public String description;

    public int maxSalary;

    public Vacancy(String name, VacancyType vacancyType, String description) {
        this.name = name;
        this.vacancyType = vacancyType;
        this.description = description;
    }
}
