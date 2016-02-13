package sk.cyklosoft.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.eshop.dao.ProductDao;
import sk.cyklosoft.eshop.dao.SizeDao;
import sk.cyklosoft.eshop.dao.SizeTypeDao;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.Size;
import sk.cyklosoft.eshop.domain.SizeType;
import sk.cyklosoft.eshop.service.SizeService;
import sk.cyklosoft.eshop.vo.ProductVO;
import sk.cyklosoft.eshop.vo.SizeVO;

@Service("sizeService")
@Component
public class SizeServiceImpl implements SizeService {
    
    @Autowired
    SizeTypeDao sizeTypeDao;
    @Autowired
    SizeDao sizeDao;
    @Autowired
    ProductDao productDao;



    @Override
    public List<SizeVO> findSizeTypes() {
        List<SizeType> sizeTypeList = sizeTypeDao.findSizeTypes();
        List<SizeVO> sizeVOList = new ArrayList<SizeVO>();
        for(SizeType sizeType: sizeTypeList) {
            sizeVOList.add(sizeType.copy());
        }
        return sizeVOList;
    }


    @Override
    public void update(Product product, ProductVO productVO) {
        delete(product);
        save(product, productVO);
        
    }


    @Override
    public void save(Product product, ProductVO productVO) {
        for(String sizeTypeId : productVO.getFormSizes()) {
            SizeType sizeType = sizeTypeDao.findSizeTypeById(sizeTypeId);
            Size size = new Size();
            size.setValue(sizeType.getValue());
            size.setProduct(product);
            sizeDao.save(size);
        }

        
    }


    @Override
    public void delete(Product product) {
        sizeDao.delete(product);
        
    }


    @Override
    public List<SizeVO> findSizes(String productId) {
        List<SizeVO> sizeVOList = findSizeTypes();
        int index = 0;
        Product product = productDao.findProductById(productId);
        for(SizeVO sizeVO: sizeVOList) {
            Size size = sizeDao.findSizeByValue(sizeVO.getValue(), product);
            if(size != null && size.getValue().equals(sizeVO.getValue())) {
                sizeVOList.get(index).setChecked(true);    
            }
            index++;
        }
        return sizeVOList;

    }


   

}
