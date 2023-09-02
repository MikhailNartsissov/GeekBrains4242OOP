package Homework3_Advanced_Exc;

import static Homework3_Advanced_Exc.ProductDatabase.*;

public class ShopManager {

    public static int checkAvailability(int productId) throws ProductNotFoundException {
        try {
            Product product = getProductById(productId);
            return 0;
        }
        catch (ProductNotFoundException ex) {
            System.out.println("Невозможно приобрести товар. " + ex.getMessage() + " Проверьте правильность ввода Id.");
        }
        return -1;
    }

    public static int checkQuantity(int productId, int quantity) throws
            ProductNotFoundException,
            NotEnoughProductInStoreException {
        try {
            int available = getQuantityById(productId, quantity);
            return available;
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
    }
