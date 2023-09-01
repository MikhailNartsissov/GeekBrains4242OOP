package Homework2_Exceptions;

public class InvalidNumberException extends Exception {

    private String errorMessage;

    public InvalidNumberException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
