package vn.aptech.springboot.amazingtoy.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.service.CategoryService;
import vn.aptech.springboot.amazingtoy.service.SubcategoryService;

import java.util.List;

@Configuration
public class CategoryFragment {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Bean(name = "getCategoryList")
    public List<Category> getCategoryList(){
        List<Category> categoryList = categoryService.findAllCat();
        return categoryList;
    }

    @Bean(name = "getSubCategoryLit")
    public List<Subcategory> getSubCategoryLit() {
        List<Subcategory> subcategories = subcategoryService.findAllSubcat();

        return subcategories;
    }
}
