package vn.aptech.springboot.amazingtoy.repository.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.order.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
