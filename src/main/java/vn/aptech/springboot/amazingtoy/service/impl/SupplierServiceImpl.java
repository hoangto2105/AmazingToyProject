package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.supplier.Supplier;
import vn.aptech.springboot.amazingtoy.repository.supplier.SupplierRepository;
import vn.aptech.springboot.amazingtoy.service.SupplierService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;


    @Override
    public List<Supplier> findAllSupplier() {
        List<Supplier> result = new ArrayList<>();
        Iterable<Supplier> listSupplier = supplierRepository.findAll();
        for (Supplier s : listSupplier) {

            result.add(s);
        }
        return result;
    }

    @Override
    public void create(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Supplier findPk(Long id) {
        try {
            Supplier supplier = supplierRepository.findById(id).get();

            return supplier;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Supplier supplier = supplierRepository.findById(id).get();
        supplierRepository.delete(supplier);
    }
}
