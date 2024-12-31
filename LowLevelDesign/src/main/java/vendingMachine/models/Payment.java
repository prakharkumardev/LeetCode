package vendingMachine.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import vendingMachine.models.enums.PaymentStatus;
import vendingMachine.models.enums.PaymentType;
import vendingMachine.observer.Observer;

@Builder
@Getter
@Setter
public class Payment extends BaseModel{
    private final PaymentType paymentType;
    private Amount amount;
    private PaymentStatus paymentStatus;

    @Override
    public void subscribe(Observer<String> observer) {

    }
}
