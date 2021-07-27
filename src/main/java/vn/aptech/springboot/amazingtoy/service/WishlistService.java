package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.wishlist.Wishlist;

import java.util.List;

public interface WishlistService {

    List<Wishlist> findAllByUser(Long userId);
    Wishlist create(Wishlist wishlist);
    void update(Wishlist wishlist);
    Wishlist findPk(Long id);
    Wishlist checkExists(Long productId, Long userId);
    void delete(Long id);

}
