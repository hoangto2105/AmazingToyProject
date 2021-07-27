package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.repository.OrderDetailRepository;
import vn.aptech.springboot.amazingtoy.service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) orderDetailRepository.findAll();
    }
}
