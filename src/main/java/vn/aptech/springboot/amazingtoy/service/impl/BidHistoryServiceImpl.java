package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.products.BidDetail;
import vn.aptech.springboot.amazingtoy.model.products.BidHistory;
import vn.aptech.springboot.amazingtoy.repository.BidHistoryRepository;
import vn.aptech.springboot.amazingtoy.service.BidDetailService;
import vn.aptech.springboot.amazingtoy.service.BidHistoryService;

import java.util.List;

@Service
public class BidHistoryServiceImpl implements BidHistoryService {

    @Autowired
    private BidHistoryRepository bidHistoryRepository;


    @Override
    public List<BidHistory> findAll() {
        return bidHistoryRepository.findAll();
    }
}
