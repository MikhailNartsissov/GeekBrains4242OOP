package ExaminationWork_ToyShopLottery;

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

    public static String getProductByChance() throws ProductNotFoundException {
        if (products.size() != 0) {
            Random lottery = new Random();
            int chance = lottery.nextInt((products.size() - 1) + 1) + 1;
            Product product = getProductById(chance);
            if (product.getAvailableQuantity() > 0) {
                product.setAvailableQuantity(product.getAvailableQuantity() - 1);
                return " You won " + product.getName() + "!";
            }
            return  " We're sorry, but " + getProductById(chance).getName() + " are over. Try to run lottery again.";
        }
        return " We're sorry, but no products in the database yet. Try register some products and run lottery again.";
    }
}
