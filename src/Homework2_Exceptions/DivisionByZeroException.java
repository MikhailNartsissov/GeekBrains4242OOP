package Homework2_Exceptions;

public class DivisionByZeroException extends Exception{

    private String errorMessage;

    public DivisionByZeroException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
