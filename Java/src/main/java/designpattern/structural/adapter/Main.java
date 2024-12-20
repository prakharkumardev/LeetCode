package designpattern.structural.adapter;

/*
Imagine an e-commerce platform that needs to integrate with multiple payment gateways
 like Stripe, PayPal, and Razorpay. Each gateway has its own API and methods for
 processing payments. To make the integration seamless and unified, we can use the
 Adapter Design Pattern to adapt the different payment gateway interfaces into a
 common interface for the application.
 */
// Client Code
public class Main {
    public static void main(String[] args) {
        // Using Stripe Adapter
        PaymentGateway stripeAdapter = new StripeAdapter(new StripePayment());
        stripeAdapter.pay(100.0);

        // Using PayPal Adapter
        PaymentGateway payPalAdapter = new PayPalAdapter(new PayPalPayment());
        payPalAdapter.pay(200.0);

        // Using Razorpay Adapter
        PaymentGateway razorpayAdapter = new RazorpayAdapter(new RazorpayPayment());
        razorpayAdapter.pay(300.0);
    }
}