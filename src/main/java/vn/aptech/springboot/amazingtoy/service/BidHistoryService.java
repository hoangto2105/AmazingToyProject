package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.products.BidHistory;

import java.util.List;

public interface BidHistoryService {

    List<BidHistory> findAll();
}
