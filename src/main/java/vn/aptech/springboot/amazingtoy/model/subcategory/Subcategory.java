package vn.aptech.springboot.amazingtoy.model.subcategory;

import vn.aptech.springboot.amazingtoy.model.category.Category;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;


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

    @JoinColumn(name = "cat_id", referencedColumnName = "category_ID")
    @ManyToOne(optional = false)
    private Category catId;

    public Subcategory() {
    }

    public Subcategory(Integer subcatId) {
        this.subcatId = subcatId;
    }

    public Subcategory(Integer subcatId, String subName) {
        this.subcatId = subcatId;
        this.subName = subName;
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

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcatId != null ? subcatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.subcatId == null && other.subcatId != null) || (this.subcatId != null && !this.subcatId.equals(other.subcatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory[ subcatId=" + subcatId + " ]";
    }

}
