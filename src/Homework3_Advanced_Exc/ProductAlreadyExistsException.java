package Homework3_Advanced_Exc;

public class ProductAlreadyExistsException extends Exception {
    private String errorMessage;

    public ProductAlreadyExistsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}

