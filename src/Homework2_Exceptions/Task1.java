package Homework2_Exceptions;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число:");
            int number = sc.nextInt();
            checkNumber(number);
        }
        catch (InvalidNumberException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkNumber(int number) throws InvalidNumberException {
        if (number <= 0) {
            throw new InvalidNumberException("Некорректное число");
        }
        System.out.println("Число корректно");
    }
}
