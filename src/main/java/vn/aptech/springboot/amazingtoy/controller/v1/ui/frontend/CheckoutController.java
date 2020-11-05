package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.cart.Cart;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkout")
    public ModelAndView checkout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        mav.addObject("listCart",list);
        mav.setViewName("frontend/layout/pages/checkout");
        Order order = new Order();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto currentUser = userService.findByEmail(authentication.getName());
        if(currentUser != null){
            order.setUser(new ModelMapper().map(currentUser, User.class));
        }
        mav.addObject("order",order);
        return mav;
    }
}
