package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.aptech.springboot.amazingtoy.model.order.Order;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.service.OrderService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "admin/order")
@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String product(Model model) {
        List<Order> orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "backend/layout/pages/order/index";
    }

    // Order detail
    @RequestMapping(value = "/orderDetail/{orderId}", method = RequestMethod.GET)
    public String inventoryDetailProduct(Model model, @PathVariable("orderId") Long id){
        Optional<Order> order = orderService.findOrderById(id);
        order.ifPresent(orderDetail->model.addAttribute("orderDetail", orderDetail));
        return "backend/layout/pages/order/orderDetail";
    }

    @RequestMapping(value = "/delete/{orderId}", method = RequestMethod.GET)
    public String removeOrder(@PathVariable("orderId") Long id){
        orderService.deleteOrder(id);
        return "redirect:/admin/order/index";
    }
}
