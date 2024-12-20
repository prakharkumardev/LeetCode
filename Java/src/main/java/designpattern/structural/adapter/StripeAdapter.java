package designpattern.structural.adapter;

// Adapter 1: Stripe Adapter
class StripeAdapter implements PaymentGateway {
    private final StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void pay(double amount) {
        stripePayment.makeStripePayment(amount);
    }
}
