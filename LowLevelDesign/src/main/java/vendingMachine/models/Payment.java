package vendingMachine.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import vendingMachine.models.enums.PaymentStatus;
import vendingMachine.models.enums.PaymentType;

@Builder
@Getter
@Setter
public class Payment extends BaseModel{
    private final PaymentType paymentType;
    private Amount amount;
    private PaymentStatus paymentStatus;
}
