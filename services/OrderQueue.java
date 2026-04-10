package services;

import model.Order;
import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    
    private Queue<Order> orderQueue = new LinkedList<>();
    private final int MAX_SIZE = 5;

    // Method to add an order to the queue using sycnhronization to make sure only one thread can access the queue one at a time
    public synchronized void addOrder(Order order) {
        while (orderQueue.size() == MAX_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderQueue.add(order);
        notifyAll();
    }

    // Method to get an order from the queue still using synchronization to ensure thread safety
    public synchronized Order getOrder() {
        while (orderQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Order order = orderQueue.poll();
        notifyAll();
        return order;
    }
}