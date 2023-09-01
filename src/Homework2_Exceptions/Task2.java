package Homework2_Exceptions;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите делимое:");
            int divisible = sc.nextInt();
            System.out.println("Введите делитель:");
            int divider = sc.nextInt();
            checkDivider(divider);
            System.out.printf("Результат целочисленного деления %d на %d равен %d%n",
                    divisible, divider, divisible / divider);
        }
        catch (DivisionByZeroException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkDivider(int number) throws DivisionByZeroException {
        if (number == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
    }
}
