package vn.aptech.springboot.amazingtoy.repository.shipping;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.shippingaddress.ShippingAddress;

@Repository
public interface AddressShippingRepository extends CrudRepository<ShippingAddress, Long> {
}
