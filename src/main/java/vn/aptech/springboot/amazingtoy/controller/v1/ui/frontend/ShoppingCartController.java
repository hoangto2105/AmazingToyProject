package vn.aptech.springboot.amazingtoy.controller.v1.ui.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.aptech.springboot.amazingtoy.model.cart.Cart;
import vn.aptech.springboot.amazingtoy.model.products.Product;
import vn.aptech.springboot.amazingtoy.service.ProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShoppingCartController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/shop/cart")
    public ModelAndView cart(Cart cart, HttpSession session){
        ModelAndView mav = new ModelAndView("frontend/layout/pages/cart");
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        mav.addObject("listCart",list);
        return mav;
    }
    @RequestMapping(value = "/shop/cart/add")
    public ModelAndView addCart(@RequestParam long id, HttpSession session){
        ModelAndView mav = new ModelAndView("frontend/layout/pages/cart");
        Product product = productService.findPk(id);
        Cart cart = new Cart();
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        if(list == null){
            list = new ArrayList<Cart>();
        }
        if(product!=null){
            cart.ToCart(product);
            Integer total = addToCart(list,cart);
            mav.addObject("total",total);
            session.setAttribute("cart",list);
        }
        mav.addObject("listCart",list);
        return mav;
    }
    private Integer addToCart(List<Cart> list, Cart cart){
        Integer total = new Integer(0);
        boolean isExist = false;
        for(Cart c : list){
            if(c.equals(cart)){
                c.setQuantity(c.getQuantity() + 1);
                isExist = true;
            }
            total = total + c.getPrice()*(new Integer(cart.getQuantity()));
        }
        if(isExist == false){
            list.add(cart);
            total = total + cart.getPrice()*(new Integer(cart.getQuantity()));
        }
        return total;
    }
    @RequestMapping(value = "/shop/cart/remove")
    public ModelAndView removeCart(@RequestParam long id, HttpSession session){
        ModelAndView mav = new ModelAndView("frontend/layout/pages/cart");
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        if(list!=null){
            Integer total = removeCartItem(list,id);
            mav.addObject("total", total);
            session.setAttribute("cart",list);
        }
        mav.addObject("listCart", list);
        return mav;
    }
    private Integer removeCartItem(List<Cart> list,long id){
        Integer total = new Integer(0);
        Cart temp = null;
        for(Cart c : list){
            if(c.getId() == (id)){
                temp = c;
                continue;
            }
            total = total + c.getPrice()*(new Integer(c.getQuantity()));
        }
        if(temp!=null){
            list.remove(temp);
        }
        return total;
    }
    @RequestMapping("/shop/cart/update")
    public ModelAndView updateCart(@RequestParam long id,
                                   @RequestParam int quantity,
                                   HttpSession session){
        ModelAndView mav = new ModelAndView("frontend/layout/pages/cart");
        List<Cart> list = (List<Cart>) session.getAttribute("cart");
        if(list!=null){
            Integer total = updateCartItem(list, id, quantity);
            mav.addObject("total",total);
            session.setAttribute("cart",list);
        }
        mav.addObject("listCart", list);
        return mav;
    }
    private Integer updateCartItem(List<Cart> list, long id, int quantity){
        Integer total = new Integer(0);
        for(Cart c : list){
            if(c.getId() == id){
                c.setQuantity(quantity);
            }
            total = total + c.getPrice()*(new Integer(c.getQuantity()));
        }
        return total;
    }
}
