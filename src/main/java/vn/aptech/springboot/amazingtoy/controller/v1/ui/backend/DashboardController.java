package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"admin", "admin/dashboard"})
@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
public class DashboardController {

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backend/layout/pages/dashboard");

        return modelAndView;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backend/layout/pages/accessDenied");
        return modelAndView;
    }
}
