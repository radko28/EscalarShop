package sk.cyklosoft.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.util.AppHelper;
import sk.cyklosoft.eshop.vo.ProductVO;

/**
 * 
 * @author radko28
 * 
 */

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("categoryList", productService.findAllCategories());
        return "homeView";

    }
    
    @RequestMapping(value ={"admin/productList","/productsByCat"}, method = RequestMethod.GET)
    public String productsByCat(@RequestParam(value = "productCatId", required = true)
    String productCatId, ModelMap model) {
        String page = "productsByCatView";
        if (AppHelper.hasAdminRole()) {
            page = "productListView";
        }
        model.addAttribute("products", productService.findProductsByCat(productCatId));
        model.addAttribute("productCategory", productService.findCatById(productCatId));
        model.addAttribute("categoryList", productService.findAllCategories());
        return page;

    }

       
    @RequestMapping(value = { "admin/product", "/product" }, method = RequestMethod.GET)
    public String productDetail(@RequestParam(value = "productId", required = true)
    String productId, ModelMap model) {
        String page = "productView";
        if (AppHelper.hasAdminRole()) {
            page = "productAdminView";
        }
        ProductVO product = productService.findProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", productService.findAllCategories());

        return page;

    }

}
