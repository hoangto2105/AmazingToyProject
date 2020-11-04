package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.aptech.springboot.amazingtoy.repository.blog.BlogRepository;
import vn.aptech.springboot.amazingtoy.service.BlogService;

@Controller

public class BlogUserController {
    @Autowired
    private BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(value="/blog")
    public String blog(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "frontend/layout/pages/blog";
    }
}
