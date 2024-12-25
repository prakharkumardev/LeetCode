package vendingMachine.adapter;

import vendingMachine.models.Amount;
import vendingMachine.models.Payment;
import vendingMachine.models.enums.PaymentStatus;
import vendingMachine.models.enums.PaymentType;

public class CashPaymentAdapter implements PaymentProcessor {

    @Override
    public Payment processPayment(Amount amount) {
        Payment payment = Payment.builder()
                .paymentType(PaymentType.CASH)
                .amount(amount)
                .paymentStatus(PaymentStatus.IN_PROGRESS)
                .build();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        return payment;
    }

}
