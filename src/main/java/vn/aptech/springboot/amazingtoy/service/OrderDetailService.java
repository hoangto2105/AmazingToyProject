package vn.aptech.springboot.amazingtoy.service;


import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> findAll();
}
