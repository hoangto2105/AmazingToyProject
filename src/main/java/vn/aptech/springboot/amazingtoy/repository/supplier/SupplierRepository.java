package vn.aptech.springboot.amazingtoy.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.supplier.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier,Long> {
}
