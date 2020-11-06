package vn.aptech.springboot.amazingtoy.model.cart;

import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.Collection;

public class Cart {
    private long id;
    private String name;
    private int price;
    private int quantity;
    private Collection<Image> photo;

    public Cart() {
    }

    public Cart(long id, String name, int price, int quantity, Collection<Image> photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Collection<Image> getPhoto() {
        return photo;
    }

    public void setPhoto(Collection<Image> photo) {
        this.photo = photo;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Cart) obj).getId();
    }

    public void ToCart(Product product) {
        this.id = product.getId();
        this.name = product.getProductName();
        this.price = product.getUnitPrice();
        this.quantity = 1;
        this.photo = product.getImagesCollection();
    }
}
