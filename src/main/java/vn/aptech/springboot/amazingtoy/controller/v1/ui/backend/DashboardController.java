package vn.aptech.springboot.amazingtoy.controller.v1.ui.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import vn.aptech.springboot.amazingtoy.dto.model.StatisticalDashboardDto;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.orderdetail.OrderDetail;
import vn.aptech.springboot.amazingtoy.model.products.BidHistory;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.service.BidHistoryService;
import vn.aptech.springboot.amazingtoy.service.OrderDetailService;
import vn.aptech.springboot.amazingtoy.service.ProductService;
import vn.aptech.springboot.amazingtoy.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = {"admin", "admin/dashboard"})
@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private BidHistoryService bidHistoryService;

    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String dashboard(Model model) {

        StatisticalDashboardDto statisticalDashboardDto = new StatisticalDashboardDto();
        List<UserDto> userDtos = userService.findAll();
        List<Product> products = productService.findAllPro();
        List<OrderDetail> orderDetails = orderDetailService.findAll();
        List<BidHistory> bidHistories = bidHistoryService.findAll();

        statisticalDashboardDto.setNewUsers(userDtos.size());
        statisticalDashboardDto.setNewOrders(orderDetails.size());
        statisticalDashboardDto.setTotalBidAuction(bidHistories.size());
        statisticalDashboardDto.setTotalProducts(products.size());
        model.addAttribute("statisticalDashboardDto", statisticalDashboardDto);

        return "backend/layout/pages/dashboard";
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("backend/layout/pages/accessDenied");
        return modelAndView;
    }
}
