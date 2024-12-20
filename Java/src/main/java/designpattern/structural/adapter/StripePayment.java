package designpattern.structural.adapter;

// Adaptee 1: Stripe Payment API
class StripePayment {
    public void makeStripePayment(double amount) {
        System.out.println("Paid " + amount + " using Stripe.");
    }
}
