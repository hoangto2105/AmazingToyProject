package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.wishlist.Wishlist;

import java.util.List;

public interface WishlistService {

    List<Wishlist> findAllWishlist();
    Wishlist create(Wishlist wishlist);
    void update(Wishlist wishlist);
    Wishlist findPk(Long id);
    void delete(Long id);

}
