package vendingMachine.models;

import lombok.*;
import vendingMachine.models.enums.PaymentStatus;


@AllArgsConstructor
@Setter
@Getter

public class VendingMachine extends BaseModel implements Machine {
    private final Inventory innverntory;
    private Amount totalAmount;
    private String name;
    private Amount unusedAmount;
    private final int THRESHOLD;
    public static class vendingMachineBuilder{
        private final Inventory innverntory = new Inventory();
        private Amount totalAmount = new Amount(0);
        private String name;
        private Amount unusedAmount = new Amount(0);
        private int threshold;
        public vendingMachineBuilder name(String name){
            this.name = name;
            return this;
        }
        public vendingMachineBuilder addProduct(Product product, Integer quantity){
            innverntory.addProduct(product, quantity);
            return this;
        }
        public vendingMachineBuilder threshold(int threshold){
            this.threshold = threshold;
            return this;
        }
        public VendingMachine build(){
            return new VendingMachine(innverntory, totalAmount, name, unusedAmount, threshold);
        }

    }

    private ProductQuantity getProductQuantity(long productId) {
        return innverntory.getProductId(productId) == null ? null : innverntory.getProductId(productId);
    }

    @Override
    public void addMoney(Payment payment) {
        if(payment.getPaymentStatus().equals((PaymentStatus.SUCCESS)))
        {
            System.out.println("Amount added to the total money" + payment.getAmount());
            unusedAmount.setValue(totalAmount.getValue() + payment.getAmount().getValue());
        }else{
            System.out.println("Payment could not be processed");
        }
    }

    @Override
    public void dispenseItem(long productId, Integer quantity) {
        //product should be in the inventory, exception product not available
        //quantity should be less than equal to the quantity in the inventory, exception not enough quantity
        //total purchase amount should be smaller than equal to unused amount, exception not enough money
        //if all the conditions are met, dispense the product and update the inventory
        ProductQuantity productQuantity = getProductQuantity(productId);
        if(productQuantity == null) {
            throw new RuntimeException("Product not available");
        }
        if(productQuantity.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }
        if(productQuantity.getProduct().getPrice().getValue() * quantity > unusedAmount.getValue()) {
            throw new RuntimeException("Not enough money");
        }
        //reducing the quantity of the innventory
        innverntory.updateProductQuantity(productQuantity.getProduct().getId(), quantity);
        //updating the total amount and unused amount
        unusedAmount.setValue(unusedAmount.getValue() - productQuantity.getProduct().getPrice().getValue() * quantity);
        totalAmount.setValue(totalAmount.getValue() + productQuantity.getProduct().getPrice().getValue() * quantity);

        System.out.println("Product dispensed: " + productQuantity.getProduct().getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + productQuantity.getProduct().getPrice().getValue() * quantity);


        //if product is less than threshold, send notification to the observer

    }

    @Override
    public void closeTransaction() {
        //reset the unused amount
        System.out.println("Transaction closed, money returned: " + unusedAmount.getValue());
        unusedAmount.setValue(0);
    }
}
