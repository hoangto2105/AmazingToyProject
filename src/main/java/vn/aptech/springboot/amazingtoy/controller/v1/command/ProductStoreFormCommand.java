package vn.aptech.springboot.amazingtoy.controller.v1.command;

import lombok.Data;
import lombok.experimental.Accessors;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.products.ProductType;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProductStoreFormCommand {

    @NotNull
    private String slug;

    @NotNull
    private String sku;

    @NotNull
    private String productName;

    private String productDescription;

    private String productContent;

    @NotNull
    @Size(min = 1)
    private int unitPrice;

    @NotNull
    private int savePrice;

    private double unitWeight;

    @NotNull
    private int stock;

    private ProductType productType;

    private boolean status;

    private int bidIncrement;

    private Date auctionStart;

    private Date auctionEnd;

    private String category;

    List<Subcategory> subcategories;
}
