package vn.aptech.springboot.amazingtoy.repository.about;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.about.About;

@Repository
public interface AboutRepository extends JpaRepository<About,Long> {
}
