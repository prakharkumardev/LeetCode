package designpattern.structural.adapter;

// Adaptee 3: Razorpay Payment API
class RazorpayPayment {
    public void makeRazorpayPayment(double amount) {
        System.out.println("Paid " + amount + " using Razorpay.");
    }
}
