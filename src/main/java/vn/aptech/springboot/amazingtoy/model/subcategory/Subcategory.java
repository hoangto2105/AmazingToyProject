package vn.aptech.springboot.amazingtoy.model.subcategory;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Subcategory")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s"),
        @NamedQuery(name = "Subcategory.findBySubcatId", query = "SELECT s FROM Subcategory s WHERE s.subcatId = :subcatId"),
        @NamedQuery(name = "Subcategory.findBySubName", query = "SELECT s FROM Subcategory s WHERE s.subName = :subName")})
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcat_id")
    private Integer subcatId;
    @Basic(optional = false)
    @Column(name = "sub_name")
    private String subName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Product> products;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Subcategory() {
    }

    public Subcategory(Integer subcatId) {
        this.subcatId = subcatId;
    }

    public Subcategory(Integer subcatId, String subName, Category category, Collection<Product> products) {
        this.subcatId = subcatId;
        this.subName = subName;
        this.category = category;
        this.products = products;
    }

    public Integer getSubcatId() {
        return subcatId;
    }

    public void setSubcatId(Integer subcatId) {
        this.subcatId = subcatId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

}
