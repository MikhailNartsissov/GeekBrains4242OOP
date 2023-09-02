package Homework3_Advanced_Exc;

public class ProductNotFoundException extends Exception {

    private String errorMessage;

    public ProductNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
