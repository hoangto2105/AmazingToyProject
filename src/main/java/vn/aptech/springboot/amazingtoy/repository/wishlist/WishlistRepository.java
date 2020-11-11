package vn.aptech.springboot.amazingtoy.repository.wishlist;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.wishlist.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist,Long> {

}
