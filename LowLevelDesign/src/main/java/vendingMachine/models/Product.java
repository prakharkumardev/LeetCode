package vendingMachine.models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vendingMachine.models.enums.ProductType;
import vendingMachine.observer.Observer;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Product extends BaseModel{
    private String name;
    private Amount price;
    private final ProductType productType;
    private Date expiryDate;


    @Override
    public void subscribe(Observer<String> observer) {

    }
}
