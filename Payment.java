public interface Payment {
    void pay(double amount);
}
public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

public class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
public class Order {
    private double amount;
    private Payment payment;

    public Order(double amount, Payment payment) {
        this.amount = amount;
        this.payment = payment;
    }

    public void processPayment() {
        payment.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCardPayment();
        Order order1 = new Order(150.0, creditCardPayment);
        order1.processPayment();  // Outputs: Paid 150.0 using Credit Card.

        Payment paypalPayment = new PayPalPayment();
        Order order2 = new Order(200.0, paypalPayment);
        order2.processPayment();  // Outputs: Paid 200.0 using PayPal.
    }
}