package vn.aptech.springboot.amazingtoy.controller.v1.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import vn.aptech.springboot.amazingtoy.model.inventory.Inventory;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInventoryRequest {

    private List<String> productIdList;

    private List<Product> productInventorList;

    private List<Long> productId;
    private List<Integer> quantity;


}
