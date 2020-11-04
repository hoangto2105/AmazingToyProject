package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllPro();
    void create(Product pro);
    void update(Product pro);
    Product findPk(Long id);
    void delete(Long id);
}
