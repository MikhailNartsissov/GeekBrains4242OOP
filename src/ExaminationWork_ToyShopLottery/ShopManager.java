package ExaminationWork_ToyShopLottery;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;


import static ExaminationWork_ToyShopLottery.ProductDatabase.*;

public class ShopManager {

    public static int checkAvailability(int productId) {
        try {
            getProductById(productId);
            return 0;
        }
        catch (ProductNotFoundException ex) {
            System.out.println("Невозможно приобрести товар. " + ex.getMessage() + " Проверьте правильность ввода Id.");
        }
        return -1;
    }

    public static int checkQuantity(int productId, int quantity) {
        try {
            return getQuantityById(productId, quantity);
        }
        catch (NotEnoughProductInStoreException ex) {
            System.out.println("Невозможно приобрести товар. " + ex.getMessage());
        }
        catch (ProductNotFoundException ex) {
            System.out.println("Невозможно приобрести товар. " + ex.getMessage() + " Проверьте правильность ввода Id.");
        }
        return -1;
    }

    public static double purchaseProduct(int productId, int quantity) throws ProductNotFoundException {
        try {
            Product product = getProductById(productId);
            return product.getPrice() * quantity;
        }
        catch (ProductNotFoundException ex) {
            System.out.println("Невозможно приобрести товар. " + ex.getMessage() + " Проверьте правильность ввода Id.");
        }
        return 0;
    }

    public static int checkProductName(String name) throws ProductAlreadyExistsException {
        if (getProductByName(name) == null) {
            return 0;
        }
        else
            throw new ProductAlreadyExistsException("Товар " + name + " уже зарегистрирован в базе данных.");
    }


    public static int registerProduct(String name, int availableQuantity, double price)
            throws ProductAlreadyExistsException {

        if (getProductByName(name) == null) {
            Product product = new Product(name, availableQuantity, price);
            addProduct(product);
            return product.getId();
            }
        else
            throw new ProductAlreadyExistsException("Товар " + name + " уже зарегистрирован в базе данных.");
        }

    public static void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.print("\n*** Register a new product in the database ***\n");
        System.out.print("Enter product name: ");
        String name = scanner.next().strip();
        try {
            if (checkProductName(name) == 0) {
                System.out.print("Enter available quantity of the product: ");
                int av_quantity = scanner.nextInt();
                System.out.print("Enter the price of the product, $: ");
                try {
                    double price = scanner.nextDouble();
                    int result = registerProduct(name, av_quantity, price);
                    if (result > 0) {
                        System.out.printf("Product registered successfully with Id = %d\n", result);
                    }
                    } catch (InputMismatchException exception) {
                        System.out.println("Incorrect price. " +
                                "Please, enter price, corresponding the following format: dd,dd");
                    }
            }
        }
        catch (ProductAlreadyExistsException ex) {
            System.out.println("Невозможно добавить товар. " + ex.getMessage());
        }
    }
        public static Double[] buyProduct (int basketCount, double basketPrice) {

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
            result[0] = (double) (basketCount);
            result[1] = basketPrice;
            return result;
        }
    public static String getLotteryResult() throws ProductNotFoundException, IOException {
        String prizeName = getProductByChance();
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        try (FileWriter writer = new FileWriter("prizes.txt", true)){
            writer.write(timeStamp + prizeName + "\n");
        }
        return prizeName;
    }
}
