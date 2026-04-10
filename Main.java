import services.OrderQueue;
import threads.Customer;
import threads.Chef;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to the restaurant!");

        OrderQueue queue = new OrderQueue();

        Thread joachim = new Thread(new Customer(1, queue));
        Thread hurveen = new Thread(new Customer(2, queue));

        Thread chef1 = new Thread(new Chef(1, queue));
        Thread chef2 = new Thread(new Chef(2, queue));

        joachim.start();
        hurveen.start();
        chef1.start();
        chef2.start();
    }
}
