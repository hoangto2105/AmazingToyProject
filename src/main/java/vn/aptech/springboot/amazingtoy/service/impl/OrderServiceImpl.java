package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.repository.order.OrderRepository;
import vn.aptech.springboot.amazingtoy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
