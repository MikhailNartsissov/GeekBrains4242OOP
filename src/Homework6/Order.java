package Homework6;


public class Order {
    protected String clientName;
    protected String product;
    protected int qnt;
    protected Double price;

    public Order(String clientName, String product, int qnt, Double price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }
}