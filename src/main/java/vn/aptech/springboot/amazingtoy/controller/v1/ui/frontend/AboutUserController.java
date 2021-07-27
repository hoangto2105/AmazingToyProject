package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.repository.about.AboutRepository;
import vn.aptech.springboot.amazingtoy.service.AboutService;

@Controller
public class AboutUserController {
    @Autowired
    private AboutService aboutService;

    @Autowired
    AboutRepository aboutRepository;

    @RequestMapping(value="/about")
    public String about(Model model){
        model.addAttribute("abouts",aboutService.findAll());
        return "frontend/layout/pages/about";
    }
//    @RequestMapping(value="about/{id}", method= RequestMethod.GET)
//    public String about(Model model, @PathVariable("id") Long id){
//        model.addAttribute("abouts",aboutService.findById(id));
//        return "frontend/layout/pages"
//    }
}






















