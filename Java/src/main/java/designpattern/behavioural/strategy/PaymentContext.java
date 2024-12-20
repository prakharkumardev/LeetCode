package designpattern.behavioural.strategy;

// Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method is not selected!");
        }
        paymentStrategy.pay(amount);
    }
}
