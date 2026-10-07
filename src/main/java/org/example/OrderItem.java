package org.example;

import java.math.BigDecimal;

public record OrderItem(
        Product product,
        int quantity


) {
    public BigDecimal getTotalPrice() {
        return product.unitPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
