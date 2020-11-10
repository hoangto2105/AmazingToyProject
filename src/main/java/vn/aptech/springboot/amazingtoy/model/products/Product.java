package vn.aptech.springboot.amazingtoy.model.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.inventory.Inventory;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.model.review.Review;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.model.user.Address;
import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;

import java.util.Collection;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "slug")
    private String slug;

    @Column(name = "sku")
    private String sku;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_content", columnDefinition = "TEXT")
    private String productContent;

    @Column(name = "unit_price", nullable = false)
    private int unitPrice;

    @Column(name = "save_price", nullable = false)
    private int savePrice;

    @Column(name = "weight")
    private double unitWeight;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "product_type")
    private ProductType productType;

    @Column(name = "hot")
    private int hot;

    @Transient
    private int quantityInventory;

    @OneToOne()
    @JoinColumn(name = "bid_detail_id")
    public BidDetail bidDetail;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Subcategory subcategory;


    @Column(name = "inventory_shipped")
    private Integer inventoryShipped;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<Image> imagesCollection;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Review> reviewsCollection;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Inventory> inventory;
}
