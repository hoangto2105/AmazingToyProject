package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.model.inventory.Inventory;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.subcategory.Subcategory;
import vn.aptech.springboot.amazingtoy.model.supplier.Supplier;
import vn.aptech.springboot.amazingtoy.service.*;

import java.util.List;

@Controller
@RequestMapping(value = "admin/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;


    // SHOW ALL
    @RequestMapping(value = {"", "/", "index"})
    public String inventory(Model model) {
        model.addAttribute("inventory",inventoryService.findAllInventory());
        return "backend/layout/pages/inventory/index";
    }


    //CREATE - GET

    @RequestMapping(value= "/createFormInvoiceDetail")
    public String displayCreateFormInvoiceDetail(Model model) {
        Inventory inventory = new Inventory();
        List<Product> productList = productService.findAllPro();
        List<Supplier> supplierList = supplierService.findAllSupplier();

        model.addAttribute("products", productList);
        model.addAttribute("suppliers", supplierList);
        model.addAttribute("inventory",inventory);
        return "backend/layout/pages/inventory/create";
    }


    //CREATE - POST

    @RequestMapping(value= "/createInvoiceDetail", method = RequestMethod.POST)
    public String createNewInvoiceDetail(Model model,
                                @ModelAttribute("inventory") Inventory inventory) {
        Product product = productService.findPk(inventory.getProduct().getId());
        Supplier supplier = supplierService.findPk(inventory.getSupplier().getId());
        inventory.setProduct(product);
        inventory.setSupplier(supplier);
        inventory.setInventoryOnHand(inventory.getStartingInventory() + inventory.getQuantityReceived());
        inventoryService.create(inventory);
        return "redirect:/admin/inventory/index";
    }


    //UPDATE - GET
//    @RequestMapping(value = "/displayUpdateProduct/{idUpdate}")
//    public String displayUpdateProduct(Model model, @PathVariable("idUpdate") String id) {
//        Product product = productService.findPk(Long.parseLong(id));
//        if(product != null) {
//            List<Subcategory> subcategoryList = subcategoryService.findAllSubcat();
//            model.addAttribute("subcategory",subcategoryList);
//            model.addAttribute("product", product);
//        }
//        return "backend/layout/pages/product/update";
//    }

    //UPDATE - POST

//    @RequestMapping(value = "/doUpdateProduct", method = RequestMethod.POST)
//    public String doUpdate(Model model,
//                           @ModelAttribute("product") Product product) {
//        Subcategory subcategory = subcategoryService.findPk(product.getSubcategory().getSubcatId());
//        product.setSubcategory(subcategory);
//        productService.update(product);
//        return "redirect:/admin/products";
//
//    }

    //DELETE
//    @RequestMapping(value = "/delete/{idDelete}", method = RequestMethod.GET)
//    public String deleteProduct(RedirectAttributes redirectAttributes, @PathVariable("idDelete") String id) {
//        Product product = productService.findPk(Long.parseLong(id));
//
//        productService.delete(Long.parseLong(id));
//        redirectAttributes.addFlashAttribute("success", "Deleted product " + product.getName() + " successfully");
//
//        return "redirect:/admin/products";
//    }



}
