package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.ProductCategory;


public interface ProductCategoryDao {

    public ProductCategory findProductCategoryById(String id);

    public void save(ProductCategory productCategory);

    public void remove(ProductCategory productCategory);

    public List<ProductCategory> findAllCategories();

    public void update(ProductCategory productCategory);

    public ProductCategory findProductCategoryByCategoryType(CategoryType categoryType);

}
