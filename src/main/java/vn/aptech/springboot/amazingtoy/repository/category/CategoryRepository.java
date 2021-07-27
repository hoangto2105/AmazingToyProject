package vn.aptech.springboot.amazingtoy.repository.category;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.category.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

    Category findBySlug(String slug);
}
