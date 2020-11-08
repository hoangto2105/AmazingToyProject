package vn.aptech.springboot.amazingtoy.service;

import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;

import java.util.List;

public interface SubcategoryService {
    List<Subcategory> findAllSubcat();
    void create(Subcategory subcategory);
    void update(Subcategory subcategory);
    Subcategory findPk(int id);
    Subcategory findBySlug(String slug);
    boolean checkSlugExists(String slug);
    void delete(int id);
}
