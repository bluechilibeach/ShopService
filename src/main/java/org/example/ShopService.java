package org.example;

import java.util.List;

public class ShopService {

    ProductRepo productRepo = new ProductRepo();

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void placeOrder(String orderId, List<String> productIds) {
        for (String productId : productIds) {
            Product product = productRepo.listProductById(productId);
        }
    }
}