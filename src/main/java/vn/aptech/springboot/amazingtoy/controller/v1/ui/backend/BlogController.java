package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.dto.model.user.blog.BlogDto;
import vn.aptech.springboot.amazingtoy.model.blog.Blog;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.BlogService;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/","","index"}, method = RequestMethod.GET)
    public String blog(Model model){
        model.addAttribute("blogs", blogService.findAll());
        return "backend/layout/pages/blog/index";
    }
//GET
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("blogDto", new BlogDto());

        return "backend/layout/pages/blog/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("blogDto")BlogDto blogDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "backend/layout/pages/blog/create";
        } else {
            try {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication != null) {
                    UserDto user = userService.findByEmail(authentication.getName());
                    blogDto.setUserDto(user);
                }
                BlogDto blog = blogService.create(blogDto);
                return "redirect:/admin/blog";
            } catch (Exception exception) {
                bindingResult.rejectValue("id", "error.blogDto", exception.getMessage());
                return "backend/layout/pages/blog/create";
            }
        }
    }
}
