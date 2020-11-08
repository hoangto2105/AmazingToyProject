package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.cart.Cart;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.model.shippingaddress.ShippingAddress;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.OrderDetailService;
import vn.aptech.springboot.amazingtoy.service.OrderService;
import vn.aptech.springboot.amazingtoy.service.ShippingAddressService;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckoutController {
    @Autowired
    private ShippingAddressService shippingAddressService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String viewCheckout(ModelMap mm,HttpSession session,@ModelAttribute("order") Order order){
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findByEmail(authentication.getName());
        User currentUser = new ModelMapper().map(userDto, User.class);
        mm.addAttribute("userDetail", currentUser);
        mm.addAttribute("order",order);
        return "frontend/layout/pages/checkout";
    }

    @RequestMapping(value = "/doCheckout", method = RequestMethod.POST)
    public String doCheckout(ModelMap mm, HttpSession session, @ModelAttribute("order") Order order) {
        HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        session.setAttribute("myCartItems", cartItems);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDto userDto = userService.findByEmail(authentication.getName());
//        User currentUser = new ModelMapper().map(userDto, User.class);
//        ShippingAddress shippingAddress = new ShippingAddress();
//        if(userDto != null) {
//            shippingAddress.setFirstName(currentUser.getFirstName());
//            shippingAddress.setLastName(currentUser.getLastName());
//            shippingAddress.setPhoneNumber(currentUser.getPhoneNumber());
//            shippingAddress.setAddress(currentUser.getAddress().getAddress());
//            shippingAddress.setCountry(currentUser.getAddress().getCountry());
//            shippingAddress.setCity(currentUser.getAddress().getCity());
//            shippingAddress.setStateOrRegion(currentUser.getAddress().getStateOrRegion());
//            shippingAddress.setPostalCode(currentUser.getAddress().getPostalCode());
//        }
        ShippingAddress shippingAddress = new ShippingAddress();
        order.setShippingAddress(shippingAddress);
        shippingAddressService.save(shippingAddress);
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
