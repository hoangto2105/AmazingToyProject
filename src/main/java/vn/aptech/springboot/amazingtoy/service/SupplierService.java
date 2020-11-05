package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.supplier.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAllSupplier();
    void create(Supplier supplier);
    void update(Supplier supplier);
    Supplier findPk(Long id);
    void delete(Long id);
}
