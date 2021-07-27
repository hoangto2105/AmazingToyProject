package vn.aptech.springboot.amazingtoy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.springboot.amazingtoy.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
