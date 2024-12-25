package vendingMachine.adapter;

import vendingMachine.models.Amount;
import vendingMachine.models.Payment;

public interface PaymentProcessor {
    Payment processPayment(Amount amount);
}
