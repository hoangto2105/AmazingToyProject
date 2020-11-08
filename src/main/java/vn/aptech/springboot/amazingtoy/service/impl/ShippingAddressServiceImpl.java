package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.shippingaddress.ShippingAddress;
import vn.aptech.springboot.amazingtoy.repository.shipping.AddressShippingRepository;
import vn.aptech.springboot.amazingtoy.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Autowired
    private AddressShippingRepository addressShippingRepository;

    @Override
    public ShippingAddress save(ShippingAddress shippingAddress) {
        return addressShippingRepository.save(shippingAddress);
    }
}
