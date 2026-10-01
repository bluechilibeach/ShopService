package org.example;

import java.util.List;

public interface OrderRepo {

    void addOrder(Order order);

    void deleteOrderById(String id);

    Order listOrdersById(String id);

    List<Order> listAllOrders();
}
