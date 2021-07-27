package vn.aptech.springboot.amazingtoy.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.aptech.springboot.amazingtoy.model.products.BidDetail;

@Repository
public interface BidDetailRepository extends JpaRepository<BidDetail, Long> {
}
