package vn.aptech.springboot.amazingtoy.model.products;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;

import java.util.Collection;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
        @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
        @NamedQuery(name = "Products.findByUnitPrice", query = "SELECT p FROM Product p WHERE p.unitPrice = :unitPrice"),
        @NamedQuery(name = "Products.findByAddedDate", query = "SELECT p FROM Product p WHERE p.addedDate = :addedDate"),
        @NamedQuery(name = "Products.findBySalePrice", query = "SELECT p FROM Product p WHERE p.salePrice = :salePrice"),
        @NamedQuery(name = "Products.findByAddedQuantity", query = "SELECT p FROM Product p WHERE p.addedQuantity = :addedQuantity"),
        @NamedQuery(name = "Products.findByStockQuantity", query = "SELECT p FROM Product p WHERE p.stockQuantity = :stockQuantity"),
        @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
        @NamedQuery(name = "Products.findByIsActive", query = "SELECT p FROM Product p WHERE p.isActive = :isActive")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private int unitPrice;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "sale_price")
    private int salePrice;
    @Column(name = "added_quantity")
    private Integer addedQuantity;
    @Basic(optional = false)
    @Column(name = "stock_quantity")
    private int stockQuantity;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Subcategory subcategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Image> imagesCollection;

    public Product(Integer productId, String name, int unitPrice, Date addedDate, int salePrice, Integer addedQuantity, int stockQuantity, String description, boolean isActive, Subcategory subcategory, Collection<Image> imagesCollection) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.addedDate = addedDate;
        this.salePrice = salePrice;
        this.addedQuantity = addedQuantity;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.isActive = isActive;
        this.subcategory = subcategory;
        this.imagesCollection = imagesCollection;
    }

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String name, int unitPrice, Date addedDate, int salePrice, int stockQuantity, String description, boolean isActive) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.addedDate = addedDate;
        this.salePrice = salePrice;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.isActive = isActive;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getAddedQuantity() {
        return addedQuantity;
    }

    public void setAddedQuantity(Integer addedQuantity) {
        this.addedQuantity = addedQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<Image> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Image> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
