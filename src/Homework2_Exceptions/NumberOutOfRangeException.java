package Homework2_Exceptions;

public class NumberOutOfRangeException extends Exception{

    private String errorMessage;

    public NumberOutOfRangeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
