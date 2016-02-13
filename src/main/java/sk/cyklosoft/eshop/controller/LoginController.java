package sk.cyklosoft.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.service.UserService;
import sk.cyklosoft.eshop.util.AppHelper;

@Controller
public class LoginController {
    
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;


    @RequestMapping(value = {"admin/login","/login"}, method = RequestMethod.GET)
    public String printLogin(ModelMap model) {
        String page = "loginView";
        model.addAttribute("categoryList", productService.findAllCategories());
        return page;

    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        String page = "";
        if (AppHelper.hasUserRole()) {
            page = "redirect:user";
        } else if (AppHelper.hasAdminRole()) {
            page = "redirect:admin";
        }

        return page;

    }


    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginFailed(ModelMap model) {
        String page = "loginView";
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("error", "true");
        return page;

    }

    @RequestMapping(value = {"admin/logout","/logout"}, method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "homeView";

    }
    
    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public String forgetPassword(ModelMap model) {
        String page = "forgetView";
        model.addAttribute("categoryList", productService.findAllCategories());
        return page;

    }
    
    @RequestMapping(value = "/forget", method = RequestMethod.POST)
    public String sendForgetPassword(@RequestParam(value = "username", required = true)
    String username, ModelMap model) {
        String page = "forgetView";
        //exists username
        boolean existUser = userService.existUser(username);
        if(existUser) {
            page = "sendForgetView";
            userService.sendNewPassword(username);
        }
        model.addAttribute("categoryList", productService.findAllCategories());
        return page;

    }


}
