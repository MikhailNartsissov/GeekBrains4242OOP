package ExaminationWork_ToyShopLottery;

public class ProductNotFoundException extends Exception {

    private String errorMessage;

    public ProductNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {return "Ошибка: " + errorMessage;}
}
