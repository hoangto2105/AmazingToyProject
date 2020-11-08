package vn.aptech.springboot.amazingtoy.model.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aptech.springboot.amazingtoy.model.products.Product;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private long id;
    private Product product;
    private int quantity;
}
