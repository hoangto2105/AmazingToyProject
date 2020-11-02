package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.service.CategoryService;

@Controller
@RequestMapping(value = "admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // SHOW ALL
    @RequestMapping(value = {"", "/", "index"})
    public String category(Model model) {
        model.addAttribute("categories",categoryService.findAllCat());
        return "backend/layout/pages/category/index";
    }


    //CREATE - GET

    @RequestMapping(value= "/createForm")
    public String displayCreateForm(Model model) {
        Category c = new Category();
        model.addAttribute("category",c);
        return "backend/layout/pages/category/create";
    }


    //CREATE - POST

    @RequestMapping(value= "/createCat", method = RequestMethod.POST)
    public String createBook(Model model,
                             @ModelAttribute("category") Category cat,
                             BindingResult result,
                             final RedirectAttributes redirectAttributes ) {
        categoryService.create(cat);
        return "redirect:/admin/category";
    }

    //UPDATE - GET
    @RequestMapping(value = "/displayUpdate/{idUpdate}")
    public String displayUpdate(Model model, @PathVariable("idUpdate") String id) {
        Category category = categoryService.findPk(Integer.parseInt(id));
        if(category != null) {
            model.addAttribute("category",category);
        }
        return "backend/layout/pages/category/update";
    }

    //UPDATE - POST

    @RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
    public String doUpdate(Model model,
                           @ModelAttribute("category") Category cat) {

        categoryService.update(cat);
        return "redirect:/admin/category";

    }

    //DELETE
    @RequestMapping(value = "/delete/{idDelete}", method = RequestMethod.GET)
    public String deleteCategory(RedirectAttributes redirectAttributes, @PathVariable("idDelete") String id) {
        Category category = categoryService.findPk(Integer.parseInt(id));

        if (category.getSubcategories().stream().count() > 0) {
            redirectAttributes.addFlashAttribute("error", "There are many subcategories inside. Remove is not allowed");
        } else {
            categoryService.delete(Integer.parseInt(id));
            redirectAttributes.addFlashAttribute("success", "Deleted category " + category.getName() + " successfully");
        }

        return "redirect:/admin/category";
    }


}
