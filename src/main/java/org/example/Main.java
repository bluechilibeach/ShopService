package org.example;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(productRepo, orderListRepo);
        OrderRepo orderRepo = new OrderMapRepo();

        System.out.println(productRepo.getAllProducts());
        productRepo.addProduct(new Product("123", "Apple", new BigDecimal("1.20")));
        productRepo.addProduct(new Product("456", "Banana", new BigDecimal("1.50")));
        productRepo.addProduct(new Product("789", "Kiwi", new BigDecimal("0.80")));

        System.out.println(productRepo.getAllProducts());
        //productRepo.deleteProductById("456");
        //System.out.println(productRepo.listAllProducts());
        //System.out.println(productRepo.listProductById("789"));
        //System.out.println(productRepo.listProductById("788"));


        System.out.println(orderListRepo.listAllOrders());

        /*
        shopService.placeOrder("78541", List.of("123", "456")); or
        List<String> productIds = List.of("123", "456");
        shopService.placeOrder("78541", productIds);
         */
        Map<String, Integer> productsForOrder78541 = Map.of(
                "456", 3,
                "789", 2
        );

        shopService.placeOrder("78541", productsForOrder78541);
        System.out.println(orderListRepo.listOrdersById("78541"));


    }
}
