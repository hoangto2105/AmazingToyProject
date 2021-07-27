package vn.aptech.springboot.amazingtoy.repository.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.order.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "select id from orders o order by o.id desc limit 1", nativeQuery = true)
    int getNextId();
}
