package vn.aptech.springboot.amazingtoy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.springboot.amazingtoy.model.user.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
