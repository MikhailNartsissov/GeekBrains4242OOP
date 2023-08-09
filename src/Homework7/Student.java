package Homework7;

public class Student implements Observer{
    private String name;
    int salary = 2000;

    public Student(String name) {
        this.name = name;
    }
    public void setVacancyType(VacancyType vacancyType) {
        this.vacancyType = vacancyType;
    }

    VacancyType vacancyType;


    @Override
    public void receiveOffer(String companyName, int salary) {
        if (this.salary <= salary){
            System.out.printf("Student %s: Мне нужна эта работа! (Company: %s, Salary: %d)\n",
                    name, companyName, salary);
            this.salary = salary;
        }
        else{
            System.out.printf("Student %s: Я найду работу получше! (Company: %s, Salary: %d)\n",
                    name, companyName, salary);
        }
    }
    @Override
    public boolean receiveVacancy(String companyName, Vacancy vacancy, int salary) {
        if (vacancyType == vacancy.vacancyType && this.salary <= salary) {
            System.out.printf("Student %s: Мне нужна эта работа! (Company: %s, Salary: %d)\n",
                    name, companyName, salary);
            this.salary = salary;
            return true;
        }
        else{
            System.out.printf("Student %s: Я найду работу получше! (Company: %s, Salary: %d)\n",
                    name, companyName, salary);
            return false;
        }
    }
}


