package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.cart.Cart;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.service.OrderDetailService;
import vn.aptech.springboot.amazingtoy.service.OrderService;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckoutController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "checkout")
    public String addUser(Model model,HttpSession session) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        if(email!= "anonymousUser") {
            UserDto currentUser = userService.findByEmail(email);
            model.addAttribute("currentUser", currentUser);
        }
        model.addAttribute("order", new Order());
        return "frontend/layout/pages/checkout";
    }
    @RequestMapping(value = "/doCheckout", method = RequestMethod.POST)
    public String doCheckout(HttpSession session,@ModelAttribute("order") Order order) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        order.setStatus(true);
        orderService.save(order);
        for(Map.Entry<Long,Cart> entry: cartItems.entrySet()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(entry.getValue().getProduct());
            orderDetail.setPrice(entry.getValue().getProduct().getSavePrice());
            orderDetail.setQuantity(entry.getValue().getQuantity());
            orderDetail.setStatus(true);
            orderDetailService.save(orderDetail);
        }
        cartItems = new HashMap<>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        return "frontend/layout/pages/success";

    }
}
