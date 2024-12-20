package designpattern.structural.adapter;

// Adapter 2: PayPal Adapter
class PayPalAdapter implements PaymentGateway {
    private final PayPalPayment payPalPayment;

    public PayPalAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void pay(double amount) {
        payPalPayment.makePayPalPayment(amount);
    }
}
