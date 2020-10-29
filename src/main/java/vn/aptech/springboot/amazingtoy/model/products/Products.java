package vn.aptech.springboot.amazingtoy.model.products;

import vn.aptech.springboot.amazingtoy.model.category.Category;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
        @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId"),
        @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
        @NamedQuery(name = "Products.findByUnitPrice", query = "SELECT p FROM Products p WHERE p.unitPrice = :unitPrice"),
        @NamedQuery(name = "Products.findByAddedDate", query = "SELECT p FROM Products p WHERE p.addedDate = :addedDate"),
        @NamedQuery(name = "Products.findBySalePrice", query = "SELECT p FROM Products p WHERE p.salePrice = :salePrice"),
        @NamedQuery(name = "Products.findByAddedQuantity", query = "SELECT p FROM Products p WHERE p.addedQuantity = :addedQuantity"),
        @NamedQuery(name = "Products.findByStockQuantity", query = "SELECT p FROM Products p WHERE p.stockQuantity = :stockQuantity"),
        @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
        @NamedQuery(name = "Products.findByIsActive", query = "SELECT p FROM Products p WHERE p.isActive = :isActive")})
public class Products implements Serializable {

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
    @JoinColumn(name = "category_id", referencedColumnName = "category_ID")
    @ManyToOne(optional = false)
    private Category categoryId;

    public Products() {
    }

    public Products(Integer productId) {
        this.productId = productId;
    }

    public Products(Integer productId, String name, int unitPrice, Date addedDate, int salePrice, int stockQuantity, String description, boolean isActive) {
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.aptech.springboot.amazingtoy.model.products.Products[ productId=" + productId + " ]";
    }

}
