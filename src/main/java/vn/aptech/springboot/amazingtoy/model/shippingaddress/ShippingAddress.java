package vn.aptech.springboot.amazingtoy.model.shippingaddress;

import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipping")
public class ShippingAddress extends BaseEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "ship_fee")
    private String shipfee;

    @Column(name = "ship_method")
    private String shipmethod;

    @Column(name = "zidcode")
    private int zipcode;
}
