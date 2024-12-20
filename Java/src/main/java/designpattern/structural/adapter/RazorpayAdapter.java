package designpattern.structural.adapter;

// Adapter 3: Razorpay Adapter
class RazorpayAdapter implements PaymentGateway {
    private final RazorpayPayment razorpayPayment;

    public RazorpayAdapter(RazorpayPayment razorpayPayment) {
        this.razorpayPayment = razorpayPayment;
    }

    @Override
    public void pay(double amount) {
        razorpayPayment.makeRazorpayPayment(amount);
    }
}
