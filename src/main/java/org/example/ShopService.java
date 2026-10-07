package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopService {

    ProductRepo productRepo = new ProductRepo();
    OrderListRepo orderListRepo = new OrderListRepo();

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public void placeOrder(String orderId, Map<String, Integer> productQuantities) {

        List<OrderItem> orderItems = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
            String orderedProductId = entry.getKey();
            Integer orderedProductQuantity = entry.getValue();

            if (orderedProductQuantity <= 0) {
                System.out.println("Quantity for product " + orderedProductId + " must be greater than 0.");
                continue;
            }

            Product product = productRepo.getProductById(orderedProductId);

            if (product == null) {
                System.out.println("The product with id " + orderedProductId + " was not found.");
            } else {
                orderItems.add(new OrderItem(product, orderedProductQuantity));
            }
        }
        if (orderItems.isEmpty()) {
            System.out.println("Order was not created because no valid products were found.");
        } else {
            orderListRepo.addOrder(new Order(orderId, orderItems));
        }
    }
}