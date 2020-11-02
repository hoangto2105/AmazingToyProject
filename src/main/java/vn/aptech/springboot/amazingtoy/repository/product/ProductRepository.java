package vn.aptech.springboot.amazingtoy.repository.product;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.products.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {
}
