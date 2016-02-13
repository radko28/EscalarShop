package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.SizeType;


public interface SizeTypeDao {
    public List<SizeType> findSizeTypes();
    public SizeType findSizeTypeById(String sizeTypeId);
}
