package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.category.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCat();
    void create(Category cat);
    void update(Category cat);
    Category findPk(int id);
    void delete(int id);
}
