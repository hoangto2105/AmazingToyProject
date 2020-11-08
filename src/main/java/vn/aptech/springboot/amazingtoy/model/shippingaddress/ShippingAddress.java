package vn.aptech.springboot.amazingtoy.model.shippingaddress;

import lombok.*;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipping_address")
public class ShippingAddress extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "state_region")
    private String stateOrRegion;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;


    @Column(name = "postal_code")
    private String postalCode;

    @OneToMany(mappedBy = "shippingAddress",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Order> orders;
}
