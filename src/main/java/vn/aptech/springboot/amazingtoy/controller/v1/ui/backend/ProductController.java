package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.service.CategoryService;
import vn.aptech.springboot.amazingtoy.service.ProductService;
import vn.aptech.springboot.amazingtoy.service.SubcategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SubcategoryService subcategoryService;

    // SHOW ALL
    @RequestMapping(value = {"", "/", "index"})
    public String product(Model model) {
        model.addAttribute("products",productService.findAllPro());
        return "backend/layout/pages/product/index";
    }

    //CREATE - GET

    @RequestMapping(value= "/createFormProduct")
    public String displayCreateFormProduct(Model model) {
        Product product = new Product();
        List<Subcategory> subcategoryList = subcategoryService.findAllSubcat();
        model.addAttribute("subcategories", subcategoryList);
        model.addAttribute("product",product);
        return "backend/layout/pages/product/index";
    }


    //CREATE - POST

    @RequestMapping(value= "/createProduct", method = RequestMethod.POST)
    public String createProduct(Model model,
                                    @ModelAttribute("Product") Product product) {
        Subcategory subcategory = subcategoryService.findPk(product.getSubcategory().getSubcatId());
        product.setSubcategory(subcategory);
        productService.create(product);
        return "redirect:/admin/products";
    }


    //UPDATE - GET
//    @RequestMapping(value = "/displayUpdateSubcategory/{idUpdate}")
//    public String displayUpdateSubcategory(Model model, @PathVariable("idUpdate") String id) {
//        Subcategory subcategory = subService.findPk(Integer.parseInt(id));
//        if(subcategory != null) {
//            List<Category> categoryList = categoryService.findAllCat();
//            model.addAttribute("categories", categoryList);
//            model.addAttribute("subcategory",subcategory);
//        }
//        return "backend/layout/pages/subcategory/update";
//    }

    //UPDATE - POST

//    @RequestMapping(value = "/doUpdateSubcategory", method = RequestMethod.POST)
//    public String doUpdate(Model model,
//                           @ModelAttribute("subcategory") Subcategory subcategory) {
//        Category category = categoryService.findPk(subcategory.getCatId().getCategoryID());
//        subcategory.setCatId(category);
//        subService.update(subcategory);
//        return "redirect:/admin/category";
//
//    }

    //DELETE
//    @RequestMapping(value = "/delete/{idDelete}", method = RequestMethod.GET)
//    public String deleteSubCategory(RedirectAttributes redirectAttributes, @PathVariable("idDelete") String id) {
//        Subcategory subcategory = subService.findPk(Integer.parseInt(id));
//
//        subService.delete(Integer.parseInt(id));
//        redirectAttributes.addFlashAttribute("success", "Deleted subcategory " + subcategory.getSubName() + " successfully");
//
//        return "redirect:/admin/category";
//    }

}

