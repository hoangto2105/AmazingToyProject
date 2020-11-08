package vn.aptech.springboot.amazingtoy.repository.subcategory;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;

public interface SubcategoryRepository extends CrudRepository<Subcategory,Integer> {

    Subcategory findBySlug(String slug);
}
