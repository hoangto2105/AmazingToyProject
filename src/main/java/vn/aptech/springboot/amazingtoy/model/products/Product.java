package vn.aptech.springboot.amazingtoy.model.products;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.model.review.Review;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;

import java.util.Collection;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "Products")
public class Product extends BaseEntity {

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private int unitPrice;
    @Basic(optional = false)
    @Column(name = "sale_price")
    private int salePrice;
    @Column(name = "added_quantity")
    private Integer addedQuantity;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Subcategory subcategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<Image> imagesCollection;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Review> reviewsCollection;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(String name, int unitPrice, int salePrice, Integer addedQuantity, String description, Subcategory subcategory, Collection<Image> imagesCollection) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.salePrice = salePrice;
        this.addedQuantity = addedQuantity;
        this.description = description;
        this.subcategory = subcategory;
        this.imagesCollection = imagesCollection;
    }
}
