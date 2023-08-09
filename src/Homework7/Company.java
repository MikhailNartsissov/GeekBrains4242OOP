package Homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Компания, которой нужны сотрудники
 */
public class Company {
    Publisher recruitingAgency;
    private Random random = new Random();
    private String name;
    private int maxSalary;

    private ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();

    public void setVacancies(ArrayList<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public Company(Publisher recruitingAgency, String name, int maxSalary) {
        this.recruitingAgency = recruitingAgency;
        this.name = name;
        this.maxSalary = maxSalary;
    }
    public void needEmployee(){
        int salary = random.nextInt(this.maxSalary);
        recruitingAgency.sendOffer(this.name, salary);
    }
    public void openVacancies(){
        if (this.vacancies.size() > 0) {
            for (Vacancy vacancy : this.vacancies) {
                int salary = random.nextInt(this.maxSalary);
                recruitingAgency.sendVacancy(this.name, vacancy, salary);
            }
        }
        else {System.out.printf("В компании %s сейчас нет открытых вакансий\n", this.name);}
        }
    }

