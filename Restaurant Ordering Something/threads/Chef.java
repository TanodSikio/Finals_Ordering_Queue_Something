package threads;

import model.Order;
import services.OrderQueue;

public class Chef extends Workers {

    private OrderQueue queue;
    private Waiter waiter;

    public Chef(int chefId, OrderQueue queue, Waiter waiter) {
        super(chefId, "Chef");
        this.queue = queue;
        this.waiter = waiter;
    }
    
    @Override
    public void run() {
        while (true) {
            Order order = queue.getOrder();
            System.out.println("Chef " + workerId + " is preparing order: " + order.getItemId() + " x" + order.getQuantity() + " for Customer " + order.getCustomerId());

            try {
                Thread.sleep(2000); // Simulate time taken to prepare the order
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Chef " + workerId + " has completed order: " + order.getItemId() + " x" + order.getQuantity() + " for Customer " + order.getCustomerId());

            waiter.addCompletedOrder(order);
        }
    }
}
