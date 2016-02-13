package sk.cyklosoft.eshop.service;

import java.util.List;

import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.vo.ProductCategoryVO;
import sk.cyklosoft.eshop.vo.ProductVO;

public interface ProductService {

    public List<ProductVO> findAllProducts();
    public List<ProductVO> findProductsByCat(String productCatId);
    public List<ProductCategoryVO> findAllCategories();
    public String findCatNameById(String productCatId);
    public ProductCategoryVO findCatById(String productCatId);
    public ProductVO findProductById(String producId);
    public void deleteProduct(String productId);
    public void deleteCategory(String productCatId);
    public void addCategory(ProductCategoryVO productCategory);
    public void addProduct(ProductVO product);
    public void updateProduct(ProductVO product);
    public void updateCategory(ProductCategoryVO productCategory);
    public String findCatIdByCategoryType(CategoryType categoryType);

}
