package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.Photo;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.Product;


public interface PhotoDao {
    
    public void save(Photo photo);

    public void deletePhotos(Product product);

    public List<Photo> findPhotosByProduct(Product product);

    public Photo findPhotoByType(Product product, PhotoType photoType);

    public void update(Photo photo);

}
