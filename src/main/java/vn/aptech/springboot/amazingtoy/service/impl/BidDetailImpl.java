package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.products.BidDetail;
import vn.aptech.springboot.amazingtoy.repository.product.BidDetailRepository;
import vn.aptech.springboot.amazingtoy.service.BidDetailService;

@Service
public class BidDetailImpl implements BidDetailService {

    @Autowired
    private BidDetailRepository bidDetailRepository;

    @Override
    public BidDetail stored(BidDetail bidDetail) {
        return bidDetailRepository.save(bidDetail);
    }
}
