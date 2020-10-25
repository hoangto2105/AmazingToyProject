package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto user = userService.findUserByEmail(authentication.getName());


        modelAndView.addObject("fullname", user.getFullName());
        modelAndView.setViewName("frontend/layout/pages/index");
        return modelAndView;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("frontend/layout/pages/accessDenied");
        return modelAndView;
    }
}
