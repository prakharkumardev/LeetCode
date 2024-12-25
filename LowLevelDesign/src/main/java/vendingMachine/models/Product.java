package vendingMachine.models;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vendingMachine.models.enums.ProductType;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseModel{
    private String name;
    private Amount price;
    private final ProductType productType;
    private Date expiryDate;


}
