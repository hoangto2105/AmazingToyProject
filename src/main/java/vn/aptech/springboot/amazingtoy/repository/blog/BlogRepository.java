package vn.aptech.springboot.amazingtoy.repository.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.blog.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
