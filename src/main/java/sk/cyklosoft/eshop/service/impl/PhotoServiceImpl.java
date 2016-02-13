package sk.cyklosoft.eshop.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sk.cyklosoft.eshop.dao.PhotoDao;
import sk.cyklosoft.eshop.domain.Photo;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.service.PhotoService;
import sk.cyklosoft.eshop.vo.ProductVO;

@Service("photoService")
@Component
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoDao photoDao;

    @Override
    public void update(Product product, ProductVO productVO, PhotoType photoType) {
        if(photoType.equals(PhotoType.MAIN)) {
            update(product, productVO.getPhoto(), PhotoType.MAIN);
        } else if(photoType.equals(PhotoType.DETAIL)) {
            update(product, productVO.getDetailPhoto(), PhotoType.DETAIL);                
        }
    }

    private void update(Product product, MultipartFile file, PhotoType photoType) {
        Photo photo = photoDao.findPhotoByType(product, photoType);  
        if(photo == null) {
            photo = new Photo();
        }
        photo.setName(file.getOriginalFilename());
        photo.setMimeContentType(file.getContentType());
        try {
            photo.setPhotoType(photoType);
            photo.setContent(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(photo.getProduct() == null) {
            photo.setProduct(product);
            photoDao.save(photo);
        } else {
            photoDao.update(photo);    
        }
    }

}
