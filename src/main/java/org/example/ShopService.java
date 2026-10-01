package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    ProductRepo productRepo = new ProductRepo();
    OrderListRepo orderListRepo = new OrderListRepo();

    public ShopService(ProductRepo productRepo, OrderListRepo orderlistRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderlistRepo;
    }

    public void placeOrder(String orderId, List<String> productIds) {

        List<Product> orderedProducts = new ArrayList<>();

        for (String productId : productIds) {
            Product product = productRepo.listProductById(productId);

            if (product == null) {
                System.out.println("The product with id " + productId + " was not found.");
            } else {
                orderedProducts.add(product);
            }
        }

        orderListRepo.addOrder(new Order(orderId, orderedProducts));
    }
}