package vendingMachine.models;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class Inventory {
    private final List<ProductQuantity> productQuantities = new ArrayList<>();

    public Integer getProductQuantity(long productId) {
        if (getProductId(productId) == null) {
            throw new RuntimeException("Product not found");
        }
        return getProductId(productId).getQuantity();
    }
    public ProductQuantity getProductId(long productId){
        for(ProductQuantity productQuantity : productQuantities) {
            if(productQuantity.getProduct().getId() == productId) {
                return productQuantity;
            }
        }
        return null;
    }

    public void addProduct(Product product, Integer quantity) {
        ProductQuantity productQuantity = getProductId(product.getId());
        if(productQuantity != null) {
            productQuantity.setQuantity(productQuantity.getQuantity() + quantity);
        } else {
            productQuantities.add(new ProductQuantity(product, quantity));
        }
    }

    public void updateProductQuantity(long productId, Integer quantity) {
        ProductQuantity productQuantity = getProductId(productId);
        if(productQuantity == null) {
            throw new RuntimeException("Product not found");
        }
        productQuantity.setQuantity(productQuantity.getQuantity() - quantity);
    }

}
