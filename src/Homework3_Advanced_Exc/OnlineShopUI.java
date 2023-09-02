/**
 * В данной работе реализуется примитивный вариант магазина
 * на основе консольного меню.
 * Функционал позволяет добавлять товары в базу данных магазина,
 * делать покупки, используя Id товара (при этом количество доступных единиц товара уменьшается на
 * количество товара в покупке,
 * Вести учёт товаров в корзине (считается общее количество и общая стоимость),
 * Исключения выбрасываются в случае, если товар не найден,
 * если количество доступных единиц товара меньше запрошенного,
 * при попытке добавить в базу уже существующий товар.
 * При вводе некорректного значения в консольном меню исключение не выбрасывается,
 * вместо этого, пользователю выводится сообщение о некорректном вводе с напоминанием, что от него ожидается.
 *.
 * На тестирование времени было мало, поэтому возможны недочеты, которые, при необходимости я готов исправить.
 */
package Homework3_Advanced_Exc;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Homework3_Advanced_Exc.ShopManager.*;

public class OnlineShopUI {
    public static void main(String[] args) throws
            ProductNotFoundException,
            ProductAlreadyExistsException,
            NotEnoughProductInStoreException {

        Scanner scanner = new Scanner(System.in);
        int basketCount = 0;
        double basketPrice = 0;
        boolean exitSelected = false;
        while (!exitSelected) {
            System.out.println("\n*** Please, select an action by entering corresponding digit ***");
            System.out.println("1 - Add product to the shop database");
            System.out.println("2 - Buy product, using Id");
            System.out.println("0 - Exit program\n");
            System.out.print("Your choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case (1) -> addProduct();
                    case (2) -> {
                        Double[] newValues = buyProduct(basketCount, basketPrice);
                        basketCount = newValues[0].intValue();
                        basketPrice = newValues[1];
                    }
                    case (0) -> exitSelected = true;
                    default -> System.out.println("Incorrect choice. Please, enter 1, 2 or 0.");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Incorrect choice. Please, enter 1, 2 or 0.\n");
                exitSelected = true;
            }
        }
    }

    public static void addProduct() throws ProductAlreadyExistsException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n*** Register a new product in the database ***\n");
        System.out.print("Enter product name: ");
        String name = scanner.next();
        try {
            if (checkProductName(name) == 0) {
                System.out.print("Enter available quantity of the product: ");
                int av_quantity = scanner.nextInt();
                System.out.print("Enter the price of the product: ");
                double price = scanner.nextDouble();
                int result = registerProduct(name, av_quantity, price);
                if (result > 0) {
                    System.out.printf("Product registered successfully with Id = %d\n", result);
                }
            }
        }
        catch (ProductAlreadyExistsException ex) {
            System.out.println("Невозможно добавить товар. " + ex.getMessage());
        }
    }

    public static Double[] buyProduct(int basketCount, double basketPrice) throws
            ProductNotFoundException,
            NotEnoughProductInStoreException {

        Scanner scanner = new Scanner(System.in);
        Double[] result = new Double[2];
        System.out.print("\n*** Search and buy a product ***\n");
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        if (checkAvailability(productId) == 0) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            if (checkQuantity(productId, quantity) > -1) {
                try {
                    double totalPrice = purchaseProduct(productId, quantity);
                    if (totalPrice > 0) {
                        System.out.printf("***\nTotal items in your basket: %d\n", basketCount + quantity);
                        System.out.printf("Total cost of your basket is $%1$,.2f\n***\n", basketPrice + totalPrice);
                        result[0] = (double) (basketCount + quantity);
                        result[1] = basketPrice + totalPrice;
                        return result;
                    }
                } catch (ProductNotFoundException ex) {
                    System.out.println("Невозможно приобрести товар. " + ex.getMessage() +
                            " Проверьте правильность ввода Id.");
                }
            }
        }
        result[0] = (double)(basketCount);
        result[1] = basketPrice;
        return result;
    }
}
