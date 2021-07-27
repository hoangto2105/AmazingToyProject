package vn.aptech.springboot.amazingtoy.model.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;
import vn.aptech.springboot.amazingtoy.model.user.User;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "bid_history")
public class BidHistory extends BaseEntity {

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "bid_detail_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private BidDetail bidDetail;

    @Column(name = "unit_price")
    private int unitPrice;
}
