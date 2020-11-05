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

    @Basic(optional = false)
    @Column(name = "description")
    private String description;

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
    private Collection<Inventory> inventory;


    public Product() {
    }

    public Product(String name, int unitPrice, int salePrice, String description, Subcategory subcategory, Integer inventoryShipped, Collection<Image> imagesCollection, Collection<Review> reviewsCollection, Collection<Inventory> inventory) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.salePrice = salePrice;
        this.description = description;
        this.subcategory = subcategory;
        this.inventoryShipped = inventoryShipped;
        this.imagesCollection = imagesCollection;
        this.reviewsCollection = reviewsCollection;
        this.inventory = inventory;
    }
}
