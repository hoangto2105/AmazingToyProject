package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.shippingaddress.ShippingAddress;

public interface ShippingAddressService {
    ShippingAddress save(ShippingAddress shippingAddress);
}
