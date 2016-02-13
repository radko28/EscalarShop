package sk.cyklosoft.eshop.dao;

import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.Size;


public interface SizeDao {
    public void save(Size size);
    public void delete(Product product);
    public Size findSizeByValue(String value, Product product);
}
