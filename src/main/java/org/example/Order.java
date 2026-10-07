package org.example;

import java.math.BigDecimal;
import java.util.List;

public record Order(
        String id,
        List<OrderItem> orderItems
) {
    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : orderItems) {
            total = total.add(item.getTotalPrice());
        }

        return total;
    }
}
