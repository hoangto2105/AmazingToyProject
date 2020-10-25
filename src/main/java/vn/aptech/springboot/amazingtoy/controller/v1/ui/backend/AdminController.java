package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Arpit Khandelwal.
 */

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/backend/layout/pages/login";
    }

}
