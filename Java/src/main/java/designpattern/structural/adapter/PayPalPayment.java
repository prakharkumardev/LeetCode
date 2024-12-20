package designpattern.structural.adapter;

// Adaptee 2: PayPal Payment API
class PayPalPayment {
    public void makePayPalPayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
