package sk.cyklosoft.eshop.service;

import java.util.List;

import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.vo.ColorVO;
import sk.cyklosoft.eshop.vo.ProductVO;



public interface ColorService {
    
    public List<ColorVO> findColorTypes();

    public void save(Product product, ProductVO productVO);

    public void update(Product product, ProductVO productVO);

    public void delete(Product product);

    public List<ColorVO> findColors(String productId);

}
