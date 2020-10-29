package vn.aptech.springboot.amazingtoy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.springboot.amazingtoy.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
