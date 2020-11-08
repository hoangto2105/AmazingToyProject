package vn.aptech.springboot.amazingtoy.model.category;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Category")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
        @NamedQuery(name = "Category.findByCategoryID", query = "SELECT c FROM Category c WHERE c.categoryID = :categoryID"),
        @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_ID")
    private Integer categoryID;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    public Category(Integer categoryID, String name, String image, Collection<Subcategory> subcategories) {
        this.categoryID = categoryID;
        this.name = name;
        this.image = image;
        this.subcategories = subcategories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Subcategory> subcategories;

    public Category() {
    }

    public Category(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Category(Integer categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }

    public Category(Integer categoryID, String name, Collection<Subcategory> subcategories) {
        this.categoryID = categoryID;
        this.name = name;
        this.subcategories = subcategories;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}

