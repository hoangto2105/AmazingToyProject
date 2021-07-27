package vn.aptech.springboot.amazingtoy.model.inventory;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.model.supplier.Supplier;
import vn.aptech.springboot.amazingtoy.model.user.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "inventory")
public class Inventory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_ID")
    private Integer inventoryID;


    @Column(name = "starting_inventory")
    private Integer startingInventory;

    @Column(name = "quantity_received")
    private Integer quantityReceived;

    @Column(name = "inventory_on_hand")
    private Integer inventoryOnHand;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;



    @Basic(optional = false)
    @Column(name = "purchase_date")
    @CreatedDate
    private Timestamp purchaseDate = new Timestamp(System.currentTimeMillis());
}

