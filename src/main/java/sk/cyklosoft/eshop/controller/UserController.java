package sk.cyklosoft.eshop.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.eshop.domain.RoleType;
import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.service.UserService;
import sk.cyklosoft.eshop.util.AppHelper;
import sk.cyklosoft.eshop.vo.UserVO;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = {"user","user/userIndex"}, method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("userId", userService.getUserIdByUsername(AppHelper.getUsername()));
        return "userIndexView";
    }
    
    @RequestMapping(value = "admin/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "userId", required = true)
    String userId,Model model, Locale locale) {
       //delete user
        userService.deleteUser(userId);
        return "redirect:userList";
    }

    
    @RequestMapping(value = {"admin/register","register"}, method = RequestMethod.GET)
    public String addUser(Model model, Locale locale) {
        model.addAttribute("user", new UserVO());
        model.addAttribute("categoryList", productService.findAllCategories());
        if(AppHelper.hasAdminRole()) {
            model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        }
        return "userAddView";
    }
    
    @RequestMapping(value = {"admin/register","register"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")
    @Valid UserVO user, BindingResult result, Model model, Locale locale) {
        String page = null;
        if(result.hasErrors()) {
            page = "userAddView";
        } else {
            userService.addUser(user);
            if(AppHelper.hasAdminRole()) {
                page = "redirect:userList";
            } else {
                page = "redirect:login";
            }
        }
        return page;
    }
      
    
    @RequestMapping(value = {"user/editUser","admin/editUser"}, method = RequestMethod.GET)
    public String editUser(@ModelAttribute("userId")
    String userId, Model model, Locale locale) {
        String page = null;
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        if(AppHelper.hasAdminRole()) {
            page = "userEditView";
        } else {
            model.addAttribute("categoryList", productService.findAllCategories());
            page = "editView";
        }
        return page;


    }
    
    @RequestMapping(value = {"user/editUser","admin/editUser"}, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")
    UserVO user, Model model, Locale locale) {
        String page = null;
        userService.updateUser(user);
        if(user.getAuthority().equals(RoleType.ROLE_ADMIN.toString())) {
            AppHelper.initUser(user.getUsername(), RoleType.ROLE_ADMIN.toString());
        }         
        if(AppHelper.hasAdminRole()) {        
            page = "redirect:userList";
        } else {
            page = "redirect:userIndex";
        }
        return page;
    }
    
    @RequestMapping(value = {"user/userDetail","admin/userDetail"}, method = RequestMethod.GET)
    public String userDetail(@RequestParam(value = "userId", required = true)
    String userId,Model model, Locale locale) {
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("user", userService.getUserById(userId));
        // model.addAttribute("confirm", messageSource.getMessage("delete.confirm", null, locale));
        return "userView";
    }
    
    
    @RequestMapping(value = {"admin/userList"}, method = RequestMethod.GET)
    public String getAdminUserList(Model model, Locale locale) {
        String page = null;
        page = "userListView";
        model.addAttribute("userList", userService.findAllUsers());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return page;
    }
    
  
    

}
