package designpattern.behavioural.strategy;

// Concrete Strategy: UPI Payment
class UpiPayment implements PaymentStrategy {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI (UPI ID: " + upiId + ").");
    }
}
