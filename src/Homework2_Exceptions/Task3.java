package Homework2_Exceptions;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Введите три числа через зяпятую: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lineArray = line.strip().split(",");
        int first, second, third;
        first = Integer.parseInt(lineArray[0].strip());
        second = Integer.parseInt(lineArray[1].strip());
        third = Integer.parseInt(lineArray[2].strip());
        try {
            checkNumbers(first, second, third);
            System.out.print("Проверка пройдена успешно");
        }
        catch (DivisionByZeroException ex) {
            System.out.println(ex.getMessage());
        }
        catch (NumberSumException ex) {
            System.out.println(ex.getMessage());
        }
        catch (NumberOutOfRangeException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void checkNumbers(int first, int second, int third) throws NumberOutOfRangeException,
            NumberSumException,
            DivisionByZeroException {
        if (first > 100) {
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }
        if (second < 0) {
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }
        if (first + second < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        }
        if (third == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
    }
}
