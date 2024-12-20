package designpattern.behavioural.strategy;

// Concrete Strategy: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card (Card Number: " + cardNumber + ").");
    }
}
