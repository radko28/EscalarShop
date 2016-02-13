package sk.cyklosoft.eshop.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.eshop.service.CartService;
import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.service.UserService;
import sk.cyklosoft.eshop.util.AppHelper;
import sk.cyklosoft.eshop.vo.ProductCategoryVO;


@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    
    @RequestMapping(value ={"admin/cart","user/cart"}, method = RequestMethod.GET)
    public String viewCart(@RequestParam(value = "userId", required = true)
    String userId, ModelMap model) {
        model.addAttribute("cartList", cartService.findCartByUserId(userId));
        model.addAttribute("categoryList", productService.findAllCategories());
        String page = "cartUserView";
        if (AppHelper.hasAdminRole()) {
            page = "cartAdminView";
        }
        return page;
    }
    
    @RequestMapping(value ={"admin/deleteCart","user/deleteCart"}, method = RequestMethod.GET)
    public String deleteCart(@RequestParam(value = "cartId", required = true)
    String cartId,@RequestParam(value = "page", required = true)
    String page,Model model, Locale locale) {
        cartService.deleteCart(cartId);
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return page;
    }

    @RequestMapping(value = "user/addCart", method = RequestMethod.POST)
    public String saveCart(@RequestParam(value = "userId", required = true)
    String userId,@RequestParam(value = "productId", required = true)
    String productId,Model model, Locale locale) {
        cartService.addCart(productId, userId);
        model.addAttribute("category", new ProductCategoryVO());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "productsByCatView";
    }
    
    
    @RequestMapping(value = {"admin/editCart","user/editCart"}, method = RequestMethod.POST)
    public String updateCart(@RequestParam(value = "cartId", required = true)
    String cartId,@RequestParam(value = "productId", required = true)
    String productId,@RequestParam(value = "amount", required = true)
    int amount, Model model, Locale locale) {
        cartService.updateCart(cartId, amount);
        String page = "redirect:user/cart";
        if (AppHelper.hasAdminRole()) {
            page = "redirect:admin/cart";
        }
        return page;
    }


}
