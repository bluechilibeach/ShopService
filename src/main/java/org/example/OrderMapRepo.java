package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.id(), order);
    }

    @Override
    public void deleteOrderById(String id) {
        if (orderMap.remove(id) != null) {
            System.out.println("Order " + id + " has been deleted.");
        }
    }

    @Override
    public Order listOrdersById(String id) {
        Order order = orderMap.get(id);

        if (order == null) {
            System.out.println("The order with id " + id + " was not found.");
        }
        return order;
    }

    @Override
    public List<Order> listAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}
