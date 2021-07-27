package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.repository.blog.BlogRepository;
import vn.aptech.springboot.amazingtoy.service.BlogService;

import java.io.IOException;

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

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public String blog(Model model, @PathVariable("id") Long id) throws IOException {
        model.addAttribute("blogs",blogService.findById(id));

        return "frontend/layout/pages/blogDetail";
    }
}
