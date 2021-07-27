package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.dto.model.user.contactUs.ContactUsDto;
import vn.aptech.springboot.amazingtoy.service.ContactUsService;
import vn.aptech.springboot.amazingtoy.service.UserService;

@Controller
@RequestMapping(value ="admin/contactUs")
public class ContactUsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactUsService contactUsService;

    @RequestMapping(value={"/","","index"},method= RequestMethod.GET)
    public String contactUs(Model model){
        model.addAttribute("contactUses",contactUsService.findAll());
        return "backend/layout/pages/contactUs/index";
    }
    //GET
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("contactUsDto",new ContactUsDto());
        return "backend/layout/pages/contactUs/create";

    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable("id") Long id){

        model.addAttribute("contactUs", contactUsService.findById(id).get());

        return "backend/layout/pages/contactUs/contactDetail";
    }

}
