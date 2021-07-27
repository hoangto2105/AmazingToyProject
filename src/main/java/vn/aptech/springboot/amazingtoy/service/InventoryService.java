package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.inventory.Inventory;
import vn.aptech.springboot.amazingtoy.model.products.Product;

import java.util.List;

public interface InventoryService {

    List<Inventory> findAllInventory();
    void create(Inventory inventory);
    void update(Inventory inventory);
    Inventory findPk(int id);
    void delete(int id);
}
