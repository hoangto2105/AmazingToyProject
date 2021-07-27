package vn.aptech.springboot.amazingtoy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.repository.category.CategoryRepository;
import vn.aptech.springboot.amazingtoy.service.CategoryService;
import vn.aptech.springboot.amazingtoy.util.RandomStringUtil;


import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository catRepo;

    @Override
    public List<Category> findAllCat() {
        List<Category> result = new ArrayList<>();
        Iterable<Category> listCat = catRepo.findAll();
        for (Category c : listCat) {

            result.add(c);
        }
        return result;
    }



    @Override
    public Category create(Category cat) {
        return catRepo.save(cat);
    }

    @Override
    public void update(Category cat) {

        catRepo.save(cat);

    }

    @Override
    public Category findPk(int id) {
        try {
            Category cat = catRepo.findById(id).get();

            return cat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findBySlug(String slug) {
        return catRepo.findBySlug(slug);
    }

    @Override
    public boolean checkSlugExists(String slug) {
        if (catRepo.findBySlug(slug) != null) {
            return true;
        }

        return false;
    }

    @Override
    public void delete(int id) {
        Category cat = catRepo.findById(id).get();
        catRepo.delete(cat);

    }
}

