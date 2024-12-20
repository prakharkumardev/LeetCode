package designpattern.behavioural.strategy;

// Concrete Strategy: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal (Email: " + email + ").");
    }
}
