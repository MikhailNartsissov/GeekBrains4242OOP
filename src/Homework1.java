import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Homework1 {
    public static class Drink {
        protected static String defaultName = "Default drink";
        protected static Integer defaultVolume = 0;
        String name;
        Integer volume;

        public Drink(String nameValue, Integer volumeValue) {
            name = nameValue;
            volume = volumeValue;
        }

        public Drink(Integer volumeValue) {
            this(defaultName, volumeValue);
        }

        public Drink() {
            this(defaultName, defaultVolume);
        }

        public String getInfo() {
            return String.format("\n*****\nDrink name: %s\nDrink volume %d\n*****",
                    this.name, this.volume);
        }
    }

    public static class HotDrink extends Drink {
        protected static Integer defaultTemperature = 70;
        Integer temperature;

        public HotDrink(String nameValue, Integer volumeValue, Integer temperatureValue) {
            name = nameValue;
            volume = volumeValue;
            temperature = temperatureValue;
        }

        public HotDrink(String nameValue, Integer temperatureValue) {
            name = nameValue;
            temperature = temperatureValue;
        }

        public HotDrink(Integer volumeValue, Integer temperatureValue) {
            volume = volumeValue;
            temperature = temperatureValue;
        }

        public HotDrink(String nameValue) {
            name = nameValue;
            temperature = defaultTemperature;
        }

        public HotDrink(Integer temperatureValue) {
            temperature = temperatureValue;
        }

        public HotDrink() {
            temperature = defaultTemperature;
        }

        public String getInfo() {
            return String.format("*****\nDrink name: %s\nDrink volume %d\nDrink temperature: %d\n*****\n",
                    super.name, super.volume, this.temperature);
        }
    }
    public static class VendingDrinkMachine {
        protected static Map<String, Integer> drinksOnSale = Map.ofEntries(
                entry("Sparkling Water", 330),
                entry("Soda Water", 350),
                entry("Mineral Water", 500),
                entry("Beer", 610),
                entry("Apple Juice", 300));


        public String getProduct(String nameValue) {
            if (drinksOnSale.get(nameValue) != null) {
                return String.format("*****\nDrink name: %s\nDrink volume: %d\n*****\n",
                        nameValue, drinksOnSale.get(nameValue));
            } else return String.format("We're sorry, %s is not on sale in this machine\n", nameValue);
        }

        public static class VendingHotDrinkMachine extends VendingDrinkMachine {
            protected static Map<String, List<Integer>> drinksOnSale = Map.ofEntries(
                    entry("Espresso", Arrays.asList(60, 70)),
                    entry("Double Espresso", Arrays.asList(120, 70)),
                    entry("Cappuccino", Arrays.asList(180, 60)),
                    entry("Latte", Arrays.asList(180, 70)),
                    entry("Latte Macchiato", Arrays.asList(200, 70)));

            @Override
            public String getProduct(String nameValue) {
                if (drinksOnSale.get(nameValue) != null) {
                    return String.format("*****\nDrink name: %s\nDrink ",
                            nameValue) +
                            drinksOnSale.get(nameValue).stream()
                                    .map(Object::toString)
                                    .collect(Collectors.joining("\nDrink temperature: ",
                                            "volume: ", "")) +
                            "\n*****\n";
                } else return String.format("We're sorry, %s is not on sale in this machine\n", nameValue);
            }

        }


        public static void main(String[] args) {
            HotDrink defaultDrink = new HotDrink();
            HotDrink water = new HotDrink("water");
            HotDrink tea = new HotDrink("tea", 90);
            HotDrink coffee = new HotDrink("coffee", 100, 60);
            System.out.println("\nHot drinks:");
            System.out.println(defaultDrink.getInfo());
            System.out.println(water.getInfo());
            System.out.println(tea.getInfo());
            System.out.println(coffee.getInfo());

            VendingDrinkMachine vendingDrinkMachine = new VendingDrinkMachine();
            System.out.println("\nVending drink machine (COLD drinks):");
            System.out.println(vendingDrinkMachine.getProduct("Sparkling Water"));
            System.out.println(vendingDrinkMachine.getProduct("Soda Water"));
            System.out.println(vendingDrinkMachine.getProduct("Mineral Water"));
            System.out.println(vendingDrinkMachine.getProduct("Beer"));
            System.out.println(vendingDrinkMachine.getProduct("Apple Juice"));
            System.out.println(vendingDrinkMachine.getProduct("Espresso"));

            VendingHotDrinkMachine vendingHotDrinkMachine = new VendingHotDrinkMachine();
            System.out.println("Vending HOT drink machine (hot drinks):");
            System.out.println(vendingHotDrinkMachine.getProduct("Espresso"));
            System.out.println(vendingHotDrinkMachine.getProduct("Double Espresso"));
            System.out.println(vendingHotDrinkMachine.getProduct("Cappuccino"));
            System.out.println(vendingHotDrinkMachine.getProduct("Latte"));
            System.out.println(vendingHotDrinkMachine.getProduct("Latte Macchiato"));
            System.out.println(vendingHotDrinkMachine.getProduct("Beer"));

        }
    }
}