package sk.cyklosoft.eshop.service;

import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.vo.ProductVO;


public interface PhotoService {

    void update(Product product, ProductVO productVO, PhotoType photoType);
    
}
