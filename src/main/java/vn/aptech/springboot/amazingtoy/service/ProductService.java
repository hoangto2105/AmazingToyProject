package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.BidHistory;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllPro();
    Product create(Product pro);
    Product update(Product pro);
    Product findPk(Long id);
    Product findBySlug(String productSlug);
    void delete(Long id);
    Product bidAuction(Product product);
    BidHistory storeBidHistory(BidHistory bidHistory);
}
