package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.order.Order;

public interface OrderService {
    Order save(Order order);
}
