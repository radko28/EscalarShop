package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.ProductCategory;


public interface ProductDao {
	
    public Product findProductById(String id);

    public void save(Product product);

    public void remove(Product product);
    
    public List<Product> findProductByCat(ProductCategory productCategory);
    
    public void update(Product product);


}
