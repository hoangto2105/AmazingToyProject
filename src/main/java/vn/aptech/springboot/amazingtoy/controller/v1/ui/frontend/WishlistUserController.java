package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.aptech.springboot.amazingtoy.dto.model.user.UserDto;
import vn.aptech.springboot.amazingtoy.model.cart.Cart;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.model.user.User;
import vn.aptech.springboot.amazingtoy.model.wishlist.Wishlist;
import vn.aptech.springboot.amazingtoy.service.ProductService;
import vn.aptech.springboot.amazingtoy.service.UserService;
import vn.aptech.springboot.amazingtoy.service.WishlistService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "wishlist")
@PreAuthorize("hasAnyAuthority('CUSTOMER')")
public class WishlistUserController {

    @Autowired
    ProductService productService;

    @Autowired
    WishlistService wishlistService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String add(HttpServletRequest httpServletRequest, @PathVariable("id") Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName() == null) {
            return "redirect:/login";
        }
        User user = userService.findUserByEmail(authentication.getName()); // get user by email
        Wishlist wishlistCurrent = wishlistService.checkExists(id, user.getId());
        if (wishlistCurrent != null) {
            return "redirect:" + httpServletRequest.getHeader("Referer").toString();
        } else {
            Product product = productService.findPk(id);

            Wishlist wishlist = new Wishlist();
            wishlist.setProduct(product);
            wishlist.setUser(user);
            wishlistService.create(wishlist);
        }

        return "redirect:/account/wishlist";
    }






    
}
