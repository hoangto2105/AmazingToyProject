package vn.aptech.springboot.amazingtoy.repository.inventory;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.inventory.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory,Integer> {
}
