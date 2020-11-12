package vn.aptech.springboot.amazingtoy.model.wishlist;

import lombok.*;
import lombok.experimental.Accessors;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.user.User;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlist")
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;


    @OneToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;


    @OneToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;
}
