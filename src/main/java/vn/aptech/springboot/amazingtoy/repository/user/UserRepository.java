package vn.aptech.springboot.amazingtoy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.springboot.amazingtoy.model.user.User;

/**
 * Created by Arpit Khandelwal.
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

}
