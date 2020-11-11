package vn.aptech.springboot.amazingtoy.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findBySlug(String slug);

    @Query(value = "select * from products p where product_name like '%' :name '%'", nativeQuery = true)
    List<Product> productSearchList(String name);

    @Query(value = "select * from products p where  p.subcategory_id = :subCategoryId && p.product_name like '%' :name '%'", nativeQuery = true)
    List<Product> searchProductBySubCategory(Long subCategoryId, String name);

    @Query(value = "select * from products p where p.unit_price between :from and :to", nativeQuery = true)
    List<Product> filterProductByPrice(Integer from, Integer to);
}
