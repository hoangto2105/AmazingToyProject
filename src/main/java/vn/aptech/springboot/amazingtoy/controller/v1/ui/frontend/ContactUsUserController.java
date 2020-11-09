package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.aptech.springboot.amazingtoy.dto.model.user.contactUs.ContactUsDto;
import vn.aptech.springboot.amazingtoy.model.contactus.ContactUs;
import vn.aptech.springboot.amazingtoy.repository.contactUsRepository.ContactUsRepository;
import vn.aptech.springboot.amazingtoy.service.ContactUsService;

@Controller
public class ContactUsUserController {

    @Autowired
    private ContactUsService contactUsService;

    @Autowired
    private ContactUsRepository contactUsRepository;

    @RequestMapping(value="/contactUs")
    public String contactUs(Model model){
        model.addAttribute("contactUses",contactUsService.findAll());
        model.addAttribute("messageCreate", new ContactUsDto());
        return "frontend/layout/pages/contactUs";
    }
    @RequestMapping(value="/createMessage", method= RequestMethod.POST)
    public String createMessage(Model model,
                                @ModelAttribute("messageCreate")ContactUsDto contactUsCreated,
                                BindingResult result,
                                final RedirectAttributes redirectAttributes){
 contactUsService.create(contactUsCreated);
 return "redirect:/index";
    }
}
