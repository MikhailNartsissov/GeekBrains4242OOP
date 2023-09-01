package Homework2_Exceptions;

public class NumberSumException extends Exception {

    private String errorMessage;

    public NumberSumException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
