package model;

public class Order {
    private String itemId;
    private int quantity;
    private int customerId;
    private int counter;

    public Order(int i, String itemId, int quantity, int customerId) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.customerId = customerId;
        this.counter = i;
    }

    public String getItemId() {
        return itemId;
    }

    public int getCounter() {
        return counter;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCustomerId() {
        return customerId;
    }
}