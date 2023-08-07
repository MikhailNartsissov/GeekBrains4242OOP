package Homework6;

public class Program {
    public static void main(String[] args) {
        System.out.println("Введите заказ:");
        UsingConsole console = new UsingConsole();
        Order order = console.inputFromConsole();
        UsingJSON json = new UsingJSON();
        json.saveToJson(order);
    }
}
