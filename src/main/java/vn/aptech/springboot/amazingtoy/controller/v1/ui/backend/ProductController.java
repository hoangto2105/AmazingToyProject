package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.dto.mapper.UserMapper;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.category.Category;
import vn.aptech.springboot.amazingtoy.model.images.Image;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.*;
import vn.aptech.springboot.amazingtoy.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "admin/products")
public class ProductController {

    private final String PRODUCTS_IMAGE_PATH = "backend/dist/img/products";

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private CategoryService categoryService;

    // SHOW ALL
    @RequestMapping(value = {"", "/", "index"}, method =RequestMethod.GET)
    public String product(Model model) {
        List<Product> products = productService.findAllPro();
        model.addAttribute("products", products);
        return "backend/layout/pages/product/index";
    }

    //Show image list of product
    @RequestMapping(value = "/imageList/{productId}")
    public String displayImageList(Model model, @PathVariable("productId") Long id){
        Product product = productService.findPk(id);
        List<Image> imageList = (List<Image>) product.getImagesCollection();
        model.addAttribute("product", product);
        return "backend/layout/pages/image/index";
    }
    @RequestMapping(value = "/doDefaultImage/{idImage}", method = RequestMethod.GET)
    public String doDefaultImage(@PathVariable("idImage") String id){
        Optional<Image> image = imageService.findPk(Integer.parseInt(id));
        Product product = productService.findPk(image.get().getProduct().getId());
        for (Image image1 : product.getImagesCollection()) {
            if (image1.getImageId() == Integer.parseInt(id)) {
                image1.setMainImage(true);
            } else {
                image1.setMainImage(false);
            }
        }

        productService.create(product);
        return "redirect:/admin/products/imageList/" + product.getId();
    }

    //create image of product

    @RequestMapping(value = "/createImages/{productId}", method = RequestMethod.GET)
    public String createImages(Model model, @PathVariable("productId") Long id){
        model.addAttribute("productId", id);
        model.addAttribute("image", new Image());
        return "backend/layout/pages/image/create";
    }

    @RequestMapping(value = "/doCreateImage", method = RequestMethod.POST)
    public String doCreateImage(@ModelAttribute("image") Image image, RedirectAttributes ra, @RequestParam("files") MultipartFile[] files, @RequestParam("productId") Long id) throws IOException{
        Product product = productService.findPk(id);
        UserDto user = userService.findById(Long.parseLong("1"));

        for (MultipartFile file : files) {
            String imageName = FileUtil.UploadedFile(file, PRODUCTS_IMAGE_PATH);
            Image storeImage = new Image();
            storeImage.setName(imageName);
            storeImage.setDescription(image.getDescription());
            storeImage.setAboutId(1);
            storeImage.setBlogId(1);
            storeImage.setUserId(new ModelMapper().map(user, User.class));
            storeImage.setProduct(product);
            imageService.saveImage(storeImage);
        }
        return "redirect:/admin/products/imageList/" + product.getId();
    }



    //CREATE - GET

    @RequestMapping(value= "/createFormProduct")
    public String displayCreateFormProduct(Model model) {
        Product product = new Product();
        List<Subcategory> subcategoryList = subcategoryService.findAllSubcat();

        model.addAttribute("subcategories", subcategoryList);
        model.addAttribute("product",product);
        return "backend/layout/pages/product/create";
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
    @RequestMapping(value = "/displayUpdateProduct/{idUpdate}")
    public String displayUpdateProduct(Model model, @PathVariable("idUpdate") String id) {
        Product product = productService.findPk(Long.parseLong(id));
        if(product != null) {
            List<Subcategory> subcategoryList = subcategoryService.findAllSubcat();
            model.addAttribute("subcategory",subcategoryList);
            model.addAttribute("product", product);
        }
        return "backend/layout/pages/product/update";
    }

    //UPDATE - POST

    @RequestMapping(value = "/doUpdateProduct", method = RequestMethod.POST)
    public String doUpdate(Model model,
                           @ModelAttribute("product") Product product) {
        Subcategory subcategory = subcategoryService.findPk(product.getSubcategory().getSubcatId());
        product.setSubcategory(subcategory);
        productService.update(product);
        return "redirect:/admin/products";

    }

    //DELETE
    @RequestMapping(value = "/delete/{idDelete}", method = RequestMethod.GET)
    public String deleteProduct(RedirectAttributes redirectAttributes, @PathVariable("idDelete") String id) {
        Product product = productService.findPk(Long.parseLong(id));

        productService.delete(Long.parseLong(id));
        redirectAttributes.addFlashAttribute("success", "Deleted product " + product.getName() + " successfully");

        return "redirect:/admin/products";
    }

}

