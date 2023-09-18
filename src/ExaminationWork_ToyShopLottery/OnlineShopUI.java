/**
 * В данной работе реализуется примитивный вариант магазина игрушек
 * на основе консольного меню.
 * Функционал позволяет добавлять товары в базу данных магазина,
 * делать покупки, используя Id товара (при этом количество доступных единиц товара уменьшается на
 * количество товара в покупке,
 * Вести учёт товаров в корзине (считается общее количество и общая стоимость),
 * Случайным образом выбирать товар из базы данных в качестве приза в лотерее.
 * Выигранный приз записывается в файл "prizes.txt" вместе с timestamp, когда он был выигран.
 * Количество товаров в базе данных уменьшается на единицу для выигранного товара.
 * Если выигранный товар закончился, возвращается строка
 * с соответствующим сообщением.
 * Исключения выбрасываются в случае, если товар не найден,
 * если количество доступных единиц товара меньше запрошенного,
 * при попытке добавить в базу уже существующий товар.
 * При вводе некорректного значения в консольном меню исключение не выбрасывается,
 * вместо этого, пользователю выводится сообщение о некорректном вводе с напоминанием, что от него ожидается.
 *.
 * На тестирование времени было мало, поэтому возможны недочеты, которые, при необходимости я готов исправить.
 */
package ExaminationWork_ToyShopLottery;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ExaminationWork_ToyShopLottery.ShopManager.*;

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
            System.out.println("3 - Take part in toy lottery");
            System.out.println("0 - Exit program\n");
            System.out.print("Your choice: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case (1) -> addNewProduct();
                    case (2) -> {
                        Double[] newValues = buyProduct(basketCount, basketPrice);
                        basketCount = newValues[0].intValue();
                        basketPrice = newValues[1];
                    }
                    case (3) -> System.out.printf("\n*** %s ***\n", getLotteryResult());
                    case (0) -> exitSelected = true;
                    default -> System.out.println("Incorrect choice. Please, enter 1, 2, 3 or 0.");
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Incorrect choice. Please, enter 1, 2 or 0.\n");
                exitSelected = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
