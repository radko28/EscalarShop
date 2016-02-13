package sk.cyklosoft.eshop.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import sk.cyklosoft.eshop.vo.ProductCategoryVO;


/**
 * 
 * @author radko28
 * 
 */
@Entity
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 5382266412810083071L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "product_cat_id", nullable = false, columnDefinition = "varchar(32)")
    private String productCatId;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(15)")
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;

    @Enumerated(EnumType.STRING)
    @Column(name = "productType", nullable = true, columnDefinition = "varchar(20)")
    private CategoryType categoryType;
    
    @Column(name = "enabled", nullable = false)
    private boolean enabled;


    public String getProductCatId() {
        return productCatId;
    }

    public void setProductCatId(String productCatId) {
        this.productCatId = productCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public ProductCategoryVO copy() {
        return new ProductCategoryVO(name, categoryType, productCatId, enabled);
    }


}
