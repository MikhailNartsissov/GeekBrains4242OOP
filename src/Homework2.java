import java.util.*;

public class Homework2 {

    public interface MarketBehaviour {
        void marketEnter(Visitor visitor);
        void marketExit(Visitor visitor);
        void update();
    }

    public interface QueueBehaviour {
        void queueIn(Visitor visitor);
        void queueOut();
        void orderMake();
        void orderReceive();
    }

    public static class Market implements MarketBehaviour, QueueBehaviour {
        List<Visitor> visitors = new LinkedList<>();
        Queue<Visitor> visitorQueue = new ArrayDeque<>();

        @Override
        public void marketEnter(Visitor visitor) {
            System.out.println(visitor.getName() + " пришёл в магазин");
            visitors.add(visitor);
        }

        @Override
        public void marketExit(Visitor visitor) {
            visitors.remove(visitor);
            System.out.println(visitor.getName() + " ушёл из магазина");
        }

        @Override
        public void update() {
        }

        @Override
        public void queueIn(Visitor visitor) {
            visitorQueue.add(visitor);
            System.out.println(visitor.getName() + " занял очередь за заказом");
        }

        @Override
        public void queueOut() {
            System.out.println(Objects.requireNonNull(visitorQueue.peek()).getName() + " ушёл из очереди");
            visitorQueue.poll();
        }

        @Override
        public void orderMake() {
            Objects.requireNonNull(visitorQueue.peek()).madeOrder();
            System.out.println(Objects.requireNonNull(visitorQueue.peek()).getName() + " сделал заказ");
        }

        @Override
        public void orderReceive() {
            Objects.requireNonNull(visitorQueue.peek()).receivedOrder();
            System.out.println(Objects.requireNonNull(visitorQueue.peek()).getName() + " получил заказ");
        }

    }

    public interface VisitorBehaviour {

        void makeOrder();
        void receiveOrder();

        default boolean madeOrder() {
            return false;
        }

        default boolean receivedOrder() {
            return false;
        }

    }

    public abstract static class Visitor implements VisitorBehaviour {
        protected String name;
        protected boolean madeOrderClass;
        protected boolean receivedOrderClass;

        abstract String getName();
    }

    public static class Customer extends Visitor {

        @Override
        String getName() {
            return name;
        }

        @Override
        public void makeOrder() {
            madeOrderClass = true;
        }

        @Override
        public void receiveOrder() {
            receivedOrderClass = true;
        }

        @Override
        public boolean madeOrder() {
            return madeOrderClass;
        }

        @Override
        public boolean receivedOrder() {
            return receivedOrderClass;
        }
    }
        public static void main(String[] args) {

            Customer first_customer = new Customer();
            first_customer.name = "Михаил";

            Customer second_customer = new Customer();
            second_customer.name = "Владислав";

            Customer third_customer = new Customer();
            third_customer.name = "Пётр";

            Market shop = new Market();

            System.out.println("\n********** Магазин открыт **********\n");

            shop.marketEnter(first_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            shop.queueIn(first_customer);
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.marketEnter(second_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            shop.queueIn(second_customer);
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.marketEnter(third_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            shop.queueIn(third_customer);
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.orderMake();
            shop.orderReceive();
            shop.queueOut();
            shop.update();
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.marketExit(first_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            shop.orderMake();
            shop.orderReceive();
            shop.queueOut();
            shop.update();
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.marketExit(second_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            shop.orderMake();
            shop.orderReceive();
            shop.queueOut();
            shop.update();
            System.out.println("Длина очереди в магазине: " + shop.visitorQueue.size());
            shop.marketExit(third_customer);
            System.out.println("Число посетителей в магазине: " + shop.visitors.size());
            System.out.println("\n********** Магазин закрыт **********\n");
        }
}
