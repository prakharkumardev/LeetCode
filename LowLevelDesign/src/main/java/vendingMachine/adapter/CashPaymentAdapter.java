package vendingMachine.adapter;

import vendingMachine.eventType.EventType;
import vendingMachine.models.Amount;
import vendingMachine.models.Payment;
import vendingMachine.models.enums.PaymentStatus;
import vendingMachine.models.enums.PaymentType;
import vendingMachine.observer.Observer;
import vendingMachine.observer.Subject;

import java.util.HashSet;
import java.util.Set;

public class CashPaymentAdapter implements PaymentProcessor, Subject<Payment> {
    private final Set<Observer<Payment>> observers = new HashSet<>();

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

    @Override
    public void subscribe(Observer<Payment> observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer<Payment> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(EventType eventType, Payment message) {
        observers.forEach((observer) -> {
            observer.update(EventType.PAYMENT, message);
        });
    }
}
