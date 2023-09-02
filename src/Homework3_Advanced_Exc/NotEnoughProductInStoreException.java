package Homework3_Advanced_Exc;

public class NotEnoughProductInStoreException extends Exception{
    private String errorMessage;

    public NotEnoughProductInStoreException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
