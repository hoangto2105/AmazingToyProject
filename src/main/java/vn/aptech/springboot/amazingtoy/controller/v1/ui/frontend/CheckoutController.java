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
import vn.aptech.springboot.amazingtoy.model.cart.CartManager;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.order.StatusType;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.repository.order.OrderRepository;
import vn.aptech.springboot.amazingtoy.service.OrderDetailService;
import vn.aptech.springboot.amazingtoy.service.OrderService;
import vn.aptech.springboot.amazingtoy.service.ProductService;
import vn.aptech.springboot.amazingtoy.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CheckoutController {
    @Autowired
    private CartManager cartManager;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/checkout")
    public String viewCheckout(Model model) {
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
    public String doCheckout(Model model,HttpSession session,@ModelAttribute("order") Order order) {

        Cart cart = cartManager.getCart(session);
        order.setStatus(true);
        order.setAmount(cart.getTotal());
        order.setStatusType(StatusType.Confirm);
        orderService.save(order);
        for(int i=0; i<cart.getItems().size(); i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(cart.getItems().get(i).getProduct());
            orderDetail.setPrice(cart.getItems().get(i).getProduct().getSavePrice());
            orderDetail.setQuantity(cart.getItems().get(i).getQuantity());
            orderDetail.setStatus(true);
            Product product = productService.findPk(cart.getItems().get(i).getProduct().getId());
            int quantityTotal = product.getStock() - cart.getItems().get(i).getQuantity();
            product.setStock(quantityTotal);
            productService.update(product);
            orderDetailService.save(orderDetail);
        }
        cartManager.removeCart(session);
        model.addAttribute("orderTest", orderRepository.getNextId());
        return "frontend/layout/pages/success";
    }
}
