package threads;

import model.Order;
import java.util.Queue;
import java.util.LinkedList;

public class Waiter extends Workers {
    private Queue<Order> completedOrders;
    
    public Waiter(int waiterId) {
        super(waiterId, "Waiter");
        this.completedOrders = new LinkedList<>();
    }
    
    @Override
    public void run() {
        while (true) {
            // Waiter checks on customers and serves them
            try {
                Thread.sleep(3000);
                System.out.println(name + " " + workerId + " is checking on customers...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public synchronized void addCompletedOrder(Order order) {
        completedOrders.add(order);
        while (true) {
            if (!completedOrders.isEmpty()) {
                Order order1 = completedOrders.poll();
                System.out.println(name + " " + workerId +
                    " delivered order to Customer " + order1.getCustomerId());
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Queue<Order> getCompletedOrders() {
        return completedOrders;
    }
}
