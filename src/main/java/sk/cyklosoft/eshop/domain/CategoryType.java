package sk.cyklosoft.eshop.domain;

import java.util.ArrayList;
import java.util.List;

import sk.cyklosoft.eshop.vo.ProductCategoryVO;

public enum CategoryType {
    COLCHONETAS("Colchonetas"),
    COMPLEMENTOS("Complementos"),
    HOMBRE("Hombre"),
    MUJER("Mujer"),
    MOCHILAS("Mochilas"),
    NO_CATEGORY("No category");

    private String value;
    
    CategoryType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static List<ProductCategoryVO> getCategoryList() {
        List<ProductCategoryVO> categoryList = new ArrayList<ProductCategoryVO>();
        for(CategoryType type:CategoryType.values()) {
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            productCategoryVO.setName(type.getValue());
            productCategoryVO.setCategoryType(type);
            categoryList.add(productCategoryVO);
        }
        return categoryList;
    }
    
    
}
