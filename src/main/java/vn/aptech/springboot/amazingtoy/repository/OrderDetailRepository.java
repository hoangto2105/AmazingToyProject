package vn.aptech.springboot.amazingtoy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail,Long> {
}
