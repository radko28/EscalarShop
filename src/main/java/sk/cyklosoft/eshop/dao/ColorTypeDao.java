package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.ColorType;


public interface ColorTypeDao {
    
    public List<ColorType> findAllColorTypes();
    public ColorType findColorTypeById(String colorTypeId);

}
