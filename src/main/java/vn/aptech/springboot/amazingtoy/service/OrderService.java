package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.order.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAllOrder();
    Order save(Order order);
    void deleteOrder(Long id);
    Optional<Order> findOrderById(Long id);
}
