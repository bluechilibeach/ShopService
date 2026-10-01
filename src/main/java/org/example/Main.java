package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(productRepo, orderListRepo);

        System.out.println(productRepo.listAllProducts());
        productRepo.addProduct(new Product("123", "Apple"));
        productRepo.addProduct(new Product("456", "Banana"));
        productRepo.addProduct(new Product("789", "Kiwi"));
        System.out.println(productRepo.listAllProducts());
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
        List<String> productIdsForOrder78541 = List.of("456", "789");
        shopService.placeOrder("78541", productIdsForOrder78541);
        System.out.println(orderListRepo.listOrdersById("78541"));


    }
}
