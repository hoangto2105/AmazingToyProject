package vn.aptech.springboot.amazingtoy.repository.images;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.products.Product;

public interface ImagesRepository extends CrudRepository<Image,Integer> {
}
