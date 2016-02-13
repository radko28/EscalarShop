package sk.cyklosoft.eshop.dao;

import sk.cyklosoft.eshop.domain.Color;
import sk.cyklosoft.eshop.domain.Product;


public interface ColorDao {
    public void save(Color color);
    public void delete(Product product);
    public Color findColorByCode(String code, Product product);
}
