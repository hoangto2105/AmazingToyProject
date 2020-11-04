package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.repository.product.ProductRepository;
import vn.aptech.springboot.amazingtoy.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> findAllPro() {
        List<Product> result = new ArrayList<>();
        Iterable<Product> listPro = productRepository.findAll();
        for (Product pro : listPro) {

            result.add(pro);
        }
        return result;
    }

    @Override
    public void create(Product pro) {
        productRepository.save(pro);
    }

    @Override
    public void update(Product pro) {
        productRepository.save(pro);
    }

    @Override
    public Product findPk(Long id) {
        try {
            Product product = productRepository.findById(id).get();

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
