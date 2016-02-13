package sk.cyklosoft.eshop.service;

import java.util.List;

import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.vo.ProductVO;
import sk.cyklosoft.eshop.vo.SizeVO;


public interface SizeService {
    public List<SizeVO> findSizeTypes();
    public void update(Product product, ProductVO productVO);
    public void save(Product product, ProductVO productVO);
    public void delete(Product product);
    public List<SizeVO> findSizes(String productId);
}
