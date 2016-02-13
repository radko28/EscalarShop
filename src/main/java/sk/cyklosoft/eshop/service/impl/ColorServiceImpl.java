package sk.cyklosoft.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.eshop.dao.ColorDao;
import sk.cyklosoft.eshop.dao.ColorTypeDao;
import sk.cyklosoft.eshop.dao.ProductDao;
import sk.cyklosoft.eshop.domain.Color;
import sk.cyklosoft.eshop.domain.ColorType;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.service.ColorService;
import sk.cyklosoft.eshop.vo.ColorVO;
import sk.cyklosoft.eshop.vo.ProductVO;

@Service("colorService")
@Component
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorTypeDao colorTypeDao;
    @Autowired
    ColorDao colorDao;
    @Autowired
    ProductDao productDao;
    

    @Override
    public List<ColorVO> findColorTypes() {
        List<ColorType> colorTypeList = colorTypeDao.findAllColorTypes();
        List<ColorVO> colorVOList = new ArrayList<ColorVO>();
        for(ColorType colorType: colorTypeList) {
            colorVOList.add(colorType.copy());
        }
        return colorVOList;
    }

    @Override
    public void save(Product product, ProductVO productVO) {
        for(String colorTypeId : productVO.getFormColors()) {
            ColorType colorType = colorTypeDao.findColorTypeById(colorTypeId);
            Color color = new Color();
            color.setName(colorType.getName());
            color.setCode(colorType.getCode());
            color.setProduct(product);
            colorDao.save(color);
        }
    }

    @Override
    public void update(Product product, ProductVO productVO) {
        delete(product);
        save(product,productVO);
        
    }

    @Override
    public void delete(Product product) {
        colorDao.delete(product);
        
    }

    @Override
    public List<ColorVO> findColors(String productId) {
        List<ColorVO> colorVOList = findColorTypes();
        int index = 0;
        Product product = productDao.findProductById(productId);
        for(ColorVO colorVO: colorVOList) {
            Color color = colorDao.findColorByCode(colorVO.getCode(), product);
            if(color != null) {
                colorVOList.get(index).setChecked(true);    
            }
            index++;
        }
        return colorVOList;

    }

}
