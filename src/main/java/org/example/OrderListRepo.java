package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {

    private List<Order> orderList = new ArrayList<>();

    public OrderListRepo(List<Order> orderList) {
        this.orderList = orderList;
    }

    public OrderListRepo() {

    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orderList, that.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderList);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orderList=" + orderList +
                '}';
    }

    public List<Order> listAllOrders() {
        return orderList;
    }

    public Order listOrdersById(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (id.equals(orderList.get(i).id())) {
                return orderList.get(i);
            }
        }
        System.out.println("The order with id " + id + " was not found.");
        return null;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void deleteOrderById(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (id.equals(orderList.get(i).id())) {
                orderList.remove(i);
                System.out.println("Order " + id + " has been deleted.");
                break;
            }
        }
    }


}
