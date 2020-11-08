package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.service.CategoryService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping(value = "admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // SHOW ALL
    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String category(Model model) {
        model.addAttribute("categories",categoryService.findAllCat());
        return "backend/layout/pages/category/index";
    }


    //CREATE - GET

    @RequestMapping(value= "/createForm", method = RequestMethod.GET)
    public String displayCreateForm(Model model) {
        Category c = new Category();
        model.addAttribute("category",c);
        return "backend/layout/pages/category/create";
    }


    //CREATE - POST
    //Cua anh Hoang ga
//    @RequestMapping(value= "/createCat", method = RequestMethod.POST)
//    public String createBook(Model model,
//                             @ModelAttribute("category") Category cat,
//                             BindingResult result,
//                             final RedirectAttributes redirectAttributes ) {
//        categoryService.create(cat);
//        return "redirect:/admin/category";
//    }

    //cua thang em lao
        @RequestMapping(value= "/createCat", method = RequestMethod.POST)
    public String createBook(Model model,
                             @ModelAttribute("category") Category cat,
                             BindingResult result,
                             final RedirectAttributes ra,@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        cat.setImage(fileName);
        Category saveCate = categoryService.create(cat);
            String uploadDir = "D:/SpringMVC/AmazingToyProject/src/main/resources/static/backend/dist/img/category-image/" + saveCate.getCategoryID();
            Path uploadPath = Paths.get(uploadDir);

            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            try {
                InputStream inputStream = multipartFile.getInputStream();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new IOException("Could not save uploaded file: " + fileName);
            }
            ra.addFlashAttribute("message","The user has been saved successfully");

        return "redirect:/admin/category/index";
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
