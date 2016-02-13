package sk.cyklosoft.eshop.vo;

import javax.validation.constraints.Size;

import sk.cyklosoft.eshop.domain.CategoryType;


public class ProductCategoryVO {

    @Size(min=3, max=20)
    private String name;
    private CategoryType categoryType;
    private String productCatId;
    private boolean enabled;

    public ProductCategoryVO(String name, CategoryType categoryType, String productCatId, boolean enabled) {
        this.name = name;
        this.categoryType = categoryType;
        this.productCatId = productCatId;
        this.enabled = enabled;
    }


    public ProductCategoryVO() {
        // TODO Auto-generated constructor stub
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public CategoryType getCategoryType() {
        return categoryType;
    }


    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }


    public String getProductCatId() {
        return productCatId;
    }


    public void setProductCatId(String productCatId) {
        this.productCatId = productCatId;
    }


    
    public boolean isEnabled() {
        return enabled;
    }


    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
