package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.service.CategoryService;
import vn.aptech.springboot.amazingtoy.service.ProductService;
import vn.aptech.springboot.amazingtoy.service.SubcategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubcategoryService subcategoryService;

    @RequestMapping(value = "product/{slug}", method = RequestMethod.GET)
    public String productDetail(Model model, @PathVariable("slug") String slug) {

        Product product = productService.findBySlug(slug);
        model.addAttribute("productDetail", product);

        if (product.getBidDetail() != null) {
            return "frontend/layout/pages/bidDetail";
        }

        return "frontend/layout/pages/productDetail";
    }

    @RequestMapping(value = "/collection/{categorySlug}", method = RequestMethod.GET)
    public String getProductByCategories(Model model, @PathVariable("categorySlug") String categorySlug) {

        List<Product> products = new ArrayList<>();
        Category category = categoryService.findBySlug(categorySlug);
        List<Category> categories = categoryService.findAllCat();;

        if (category == null || categories.size() == 0) {
            return "redirect:/accessDenied";
        }

        for (Subcategory subCategory : category.getSubcategories()) {
            for (Product product : subCategory.getProducts()) {
                products.add(product);
            }
        }

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("category", category);

        return "frontend/layout/pages/productCategoryList";

    }

    @RequestMapping(value = "/collection/{categorySlug}/{subCategorySlug}", method = RequestMethod.GET)
    public String getProductBySubCategories(Model model, @PathVariable("categorySlug") String categorySlug, @PathVariable("subCategorySlug") String subCategorySlug) {
        Subcategory subcategory = subcategoryService.findBySlug(subCategorySlug);
        List<Category> categories = categoryService.findAllCat();

        if (subcategory == null || categories.size() == 0) {
            return "redirect:/accessDenied";
        }

        model.addAttribute("categories", categories);
        model.addAttribute("subcategory", subcategory);

        return "frontend/layout/pages/productSubCategoryList";

    }
}
