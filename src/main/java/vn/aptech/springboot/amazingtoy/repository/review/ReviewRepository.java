package vn.aptech.springboot.amazingtoy.repository.review;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.review.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
