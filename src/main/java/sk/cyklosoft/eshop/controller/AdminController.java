package sk.cyklosoft.eshop.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.RecommendedType;
import sk.cyklosoft.eshop.service.ColorService;
import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.service.SizeService;
import sk.cyklosoft.eshop.service.UserService;
import sk.cyklosoft.eshop.util.AppHelper;
import sk.cyklosoft.eshop.vo.ProductCategoryVO;
import sk.cyklosoft.eshop.vo.ProductVO;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    ColorService colorService;
    @Autowired
    SizeService sizeService;
    

    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
        // model.addAttribute("userList", userManager.findAllUsers());
        // model.addAttribute("confirm", messageSource.getMessage("delete.confirm", null, locale));
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("categoryList", productService.findAllCategories());
        return "adminRoleView";
    }
    
    @RequestMapping(value = "categoryList", method = RequestMethod.GET)
    public String categoryList(Model model, Locale locale) {
        // model.addAttribute("confirm", messageSource.getMessage("delete.confirm", null, locale));
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "categoryListView";
    }
    
    
   
    @RequestMapping(value = "deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(@RequestParam(value = "productCatId", required = true)
    String productCatId,Model model, Locale locale) {
        productService.deleteCategory(productCatId);
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "categoryListView";
    }

    @RequestMapping(value = "addEditCategory", method = RequestMethod.GET)
    public String addEditCategory(Model model, Locale locale, String productCatId) {
        
        if (null == productCatId || productCatId.length() < 1) {
            model.addAttribute("category", new ProductCategoryVO());
            model.addAttribute("createEdit", AppHelper.FROM_ADD);
            model.addAttribute("legend",messageSource.getMessage("category.add.legend", null, locale));
        } else {
            ProductCategoryVO category = productService.findCatById(productCatId);
            model.addAttribute("category", category);
            model.addAttribute("createEdit", AppHelper.FROM_EDIT);    
            model.addAttribute("legend",messageSource.getMessage("category.edit.legend", null, locale) + " " + category.getName());
        }
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "categoryAdminView";
    }
    
   @RequestMapping(value = "addEditCategory", method = RequestMethod.POST)
    public String saveCategory(HttpServletRequest req, @ModelAttribute("category")
     @Valid ProductCategoryVO productCategory, BindingResult result, Model model, Locale locale) {
       String page = "addEditCategory";
       if(result.hasErrors()) {
           page = "categoryAdminView";
       } else {
           String action = ServletRequestUtils.getStringParameter(req, "action", "");       
           if (action.contains(AppHelper.FROM_ADD)) {
               productService.addCategory(productCategory);
           } else {
               productService.updateCategory(productCategory);
           }
           model.addAttribute("categoryList", productService.findAllCategories());
           model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
           page = "categoryListView";
       }
       return page;
    }
    
    @RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam(value = "productId", required = true)
    String productId,Model model, Locale locale) {
        String productCatId = productService.findProductById(productId).getProductCategory().getProductCatId();
       //delete product
        productService.deleteProduct(productId);
        
        model.addAttribute("products", productService.findProductsByCat(productCatId));
        model.addAttribute("productCategory", productService.findCatById(productCatId));
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "productListView";
    }
      
    @RequestMapping(value = "addEditProduct", method = RequestMethod.GET)
    public String addEditProduct(Model model, Locale locale, ModelMap modelMap, String productId, String productCatId) {
        
        if (null == productId || productId.length() < 1) {
            model.addAttribute("product", new ProductVO());
            model.addAttribute("createEdit", AppHelper.FROM_ADD);
            model.addAttribute("legend",messageSource.getMessage("product.add.legend", null, locale));
            modelMap.put("sizeTypeList",sizeService.findSizeTypes());
            modelMap.put("colorTypeList",colorService.findColorTypes());            
            modelMap.put("categoryInit",null);
        } else {
            ProductVO product = productService.findProductById(productId);
            productCatId = product.getProductCategory().getProductCatId();
            model.addAttribute("product", product);
            model.addAttribute("createEdit", AppHelper.FROM_EDIT);    
            model.addAttribute("legend",messageSource.getMessage("product.edit.legend", null, locale) + " " + product.getName());
            modelMap.put("sizeTypeList",sizeService.findSizes(productId));
            modelMap.put("colorTypeList",colorService.findColors(productId));
            modelMap.put("categoryInit",productService.findProductById(productId).getProductCategory());
            Map<PhotoType, String> photoBytes = product.getPhotoBytes();
            for(Map.Entry<PhotoType, String> e : photoBytes.entrySet()) {
                if(e.getKey().equals(PhotoType.MAIN)) {
                    model.addAttribute("photo", e.getValue());
                } else if(e.getKey().equals(PhotoType.DETAIL)) {
                    model.addAttribute("detailPhoto", e.getValue());                
                }
            }

            
        }
        model.addAttribute("productCatId", productCatId);
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("categoryTypeList",CategoryType.getCategoryList());
        modelMap.put("recommendedTypeList",RecommendedType.getRecommendedTypeMap());
        
        return "productAdminView";
    }
    
    @RequestMapping(value = "addEditProduct", method = RequestMethod.POST)
    public String saveProduct(HttpServletRequest req, @ModelAttribute("product")
    ProductVO product, Model model, Locale locale) {
        String action = ServletRequestUtils.getStringParameter(req, "action", "");
        
        if (action.contains(AppHelper.FROM_ADD)) {
            productService.addProduct(product);
        } else {
            product.setProductId(ServletRequestUtils.getStringParameter(req, "productId", ""));
            productService.updateProduct(product);
        }
        String productCatId = productService.findCatIdByCategoryType(product.getCategoryType());
        model.addAttribute("products", productService.findProductsByCat(productCatId));
        model.addAttribute("productCategory", productService.findCatById(productCatId));
        model.addAttribute("categoryList", productService.findAllCategories());
        model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        return "productListView";
    }
}
