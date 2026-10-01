package org.example;


public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        OrderListRepo orderListRepo = new OrderListRepo();


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


    }
}
