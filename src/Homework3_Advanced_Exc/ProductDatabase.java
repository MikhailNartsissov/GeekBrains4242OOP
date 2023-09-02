package Homework3_Advanced_Exc;

import java.util.*;

public class ProductDatabase {
    private static ArrayList<Product> products = new ArrayList<>();
    public static Product getProductById(int productId) throws ProductNotFoundException {
        for (Product item: products) {
            if (item.getId() == productId) {return item;}
        }
        throw new ProductNotFoundException("Товар с Id = " + productId + " в базе данных не обнаружен.");
    }

    public static int getQuantityById(int productId, int quantity) throws
            ProductNotFoundException,
            NotEnoughProductInStoreException {
        for (Product item: products) {
            if (item.getId() == productId) {
                int available = item.getAvailableQuantity();
                if (available >= quantity) {
                    item.setAvailableQuantity(available - quantity);
                    return available;
                    }
                else {
                    throw new NotEnoughProductInStoreException("Такого количества товара нет на складе. " +
                            "Пожалуйста, уменьшите количество. Максимум " + available + " единиц.");
                }
            }
        }
        throw new ProductNotFoundException("Товар с Id = " + productId + " в базе данных не обнаружен.");
    }

    public static Product getProductByName(String name) {
        if (products != null) {
            for (Product item : products) {
                if (Objects.equals(item.getName(), name)) {
                    return item;
                }
            }
        }
        return null;
    }

    public static void addProduct(Product product) {
        products.add(product);
    }
}
