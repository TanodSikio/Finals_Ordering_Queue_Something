package threads;

import model.Order;
import services.OrderQueue;
import java.util.Random;

public class Customer implements Runnable {
    private int customerId;
    private OrderQueue orderQueue;
    private static int orderCounter = 1;

    private String[] menuItems = {"Burger", "Pizza", "Pasta", "Sopao", "Siomai"};

    public Customer(int customerId, OrderQueue orderQueue) {
        this.customerId = customerId;
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {

        //To randomly select items from the menu and place orders
        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            String itemId = menuItems[random.nextInt(menuItems.length)];
            int quantity = random.nextInt(5) + 1;
            Order order = new Order(orderCounter++, itemId, quantity, customerId);

            orderQueue.addOrder(order);

            System.out.println("Customer " + customerId + " placed an order: " + itemId + " x" + quantity);

            try {
                Thread.sleep(random.nextInt(3000) + 1000); // Simulate time between orders
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}