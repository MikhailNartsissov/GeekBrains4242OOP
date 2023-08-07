package Homework6;

public class UsingConsole {
    public Order inputFromConsole() {
        String clientName = InputHelper.prompt("Client name: ");
        String product = InputHelper.prompt("Product: ");
        int qnt = Integer.parseInt(InputHelper.prompt("Quantity: "));
        double price = Double.parseDouble(InputHelper.prompt("Price: "));
        return new Order(clientName, product, qnt, price);
    }
  }
