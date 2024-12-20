package designpattern.behavioural.strategy;
/*
Real-World Use Case: Payment Processing System

In an e-commerce application, customers can choose between multiple payment methods
like Credit Card, PayPal, or UPI. Each payment method has its own processing logic.
Using the Strategy Design Pattern, we can define a family of payment algorithms (strategies)
and make them interchangeable without modifying the client code.
 */


// Client Code
public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Using Credit Card Payment
        paymentContext.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        paymentContext.executePayment(150.75);

        // Using PayPal Payment
        paymentContext.setPaymentStrategy(new PayPalPayment("user@example.com"));
        paymentContext.executePayment(200.50);

        // Using UPI Payment
        paymentContext.setPaymentStrategy(new UpiPayment("user@upi"));
        paymentContext.executePayment(500.00);
    }
}
