package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.review.Review;
import vn.aptech.springboot.amazingtoy.repository.review.ReviewRepository;
import vn.aptech.springboot.amazingtoy.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }
}
