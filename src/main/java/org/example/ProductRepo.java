package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private List<Product> productList = new ArrayList<>();


    public ProductRepo(List<Product> productList) {
        this.productList = productList;
    }

    public ProductRepo() {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productList);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productList=" + productList +
                '}';
    }


    public List<Product> listAllProducts() {
        return productList;
    }

    public Product listProductById(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).id())) {
                return productList.get(i);
            }
        }
        System.out.println("The product with id " + id + " was not found.");
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProductById(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).id())) {
                productList.remove(i);
                System.out.println("Product " + id + " has been deleted.");
                break;
            }
        }
    }
}
