package vn.aptech.springboot.amazingtoy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.springboot.amazingtoy.model.products.BidHistory;

public interface BidHistoryRepository extends JpaRepository<BidHistory, Long> {
}
