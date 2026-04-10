package threads;

import model.Order;
import services.OrderQueue;

public class Chef implements Runnable {

    private OrderQueue queue;
    private int chefId;

    public Chef(int chefId, OrderQueue queue) {
        this.chefId = chefId;
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while (true) {
            Order order = queue.getOrder();
            System.out.println("Chef " + chefId + " is preparing order: " + order.getItemId() + " x" + order.getQuantity() + " for Customer " + order.getCustomerId());

            try {
                Thread.sleep(2000); // Simulate time taken to prepare the order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Chef " + chefId + " has completed order: " + order.getItemId() + " x" + order.getQuantity() + " for Customer " + order.getCustomerId());
        }
    }
}
