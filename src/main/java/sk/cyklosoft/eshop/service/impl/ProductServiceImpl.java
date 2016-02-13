package sk.cyklosoft.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import sk.cyklosoft.eshop.dao.PhotoDao;
import sk.cyklosoft.eshop.dao.ProductCategoryDao;
import sk.cyklosoft.eshop.dao.ProductDao;
import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.Photo;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.ProductCategory;
import sk.cyklosoft.eshop.service.ColorService;
import sk.cyklosoft.eshop.service.PhotoService;
import sk.cyklosoft.eshop.service.ProductService;
import sk.cyklosoft.eshop.service.SizeService;
import sk.cyklosoft.eshop.vo.ProductCategoryVO;
import sk.cyklosoft.eshop.vo.ProductVO;

/**
 * 
 * @author radko28
 * 
 */
@Service("productService")
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Autowired
    PhotoDao photoDao;
    @Autowired
    SizeService sizeService;
    @Autowired
    ColorService colorService;
    @Autowired
    PhotoService photoService;

    public List<ProductVO> findAllProducts() {
        List<Product> productList = productDao.findProductByCat(null);
        // copy
        List<ProductVO> result = new ArrayList<ProductVO>();
        for (Product product : productList) {
            result.add(product.copy());
        }

        return result;
    }

    @Override
    public List<ProductCategoryVO> findAllCategories() {
        List<ProductCategory> productCategories = productCategoryDao.findAllCategories();
        // copy
        List<ProductCategoryVO> result = new ArrayList<ProductCategoryVO>();
        for (ProductCategory productCategory : productCategories) {
            result.add(productCategory.copy());
        }

        return result;
    }

    @Override
    public List<ProductVO> findProductsByCat(String productCatId) {
        ProductCategory pc = productCategoryDao.findProductCategoryById(productCatId);
        List<Product> productList = productDao.findProductByCat(pc);
        // copy
        List<ProductVO> result = new ArrayList<ProductVO>();
        for (Product product : productList) {
            result.add(findProductById(product.getProductId()));
        }

        return result;
    }

    @Override
    public ProductCategoryVO findCatById(String productCatId) {
        ProductCategory pc = productCategoryDao.findProductCategoryById(productCatId);
        return pc.copy();
    }

    @Override
    public ProductVO findProductById(String productId) {
        Product product = productDao.findProductById(productId);
        List<Photo> photos = photoDao.findPhotosByProduct(product);
        ProductVO result = product.copy();
        result.setPhotoDB(photos);
        return result;
    }

    @Override
    public void deleteProduct(String productId) {
        Product product = productDao.findProductById(productId);
        sizeService.delete(product);
        colorService.delete(product);
        photoDao.deletePhotos(product);
        productDao.remove(product);
    }

    @Override
    public void deleteCategory(String productCatId) {
        ProductCategory pc = productCategoryDao.findProductCategoryById(productCatId);
        List<Product> productList = productDao.findProductByCat(pc);
        ProductCategory noCategory = productCategoryDao.findProductCategoryByCategoryType(CategoryType.NO_CATEGORY);
        for(Product product : productList) {
            product.setProductCategory(noCategory);
            productDao.update(product);    
        }
        productCategoryDao.remove(pc);
    }

    @Override
    public void addCategory(ProductCategoryVO productCategoryVO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(productCategoryVO.getCategoryType());
        productCategory.setName(productCategoryVO.getName());
        productCategoryDao.save(productCategory);
    }

    @Override
    public void addProduct(ProductVO productVO) {
        ProductCategory pc = productCategoryDao.findProductCategoryByCategoryType(productVO.getCategoryType());
        
        Product product = new Product();
        product.setAbout(productVO.getAbout());
        product.setDescription(productVO.getDescription());
        product.setEnabled(productVO.isEnabled());
        product.setFeatures(productVO.getFeatures());
        product.setName(productVO.getName());
        product.setProductCategory(pc);
        product.setPrice(productVO.getPrice());
        product.setRecomended(productVO.getRecommended());
        product.setWeight(productVO.getWeight());
       
        productDao.save(product);
//size
        sizeService.save(product, productVO);
//color
        colorService.save(product, productVO);
//main photo
        MultipartFile photoPart = productVO.getPhoto();
        if(photoPart != null && photoPart.getOriginalFilename() != null && photoPart.getOriginalFilename().length() > 0) {
            photoService.update(product, productVO, PhotoType.MAIN);
        }
        //detail photo
        MultipartFile detailPhotoPart = productVO.getDetailPhoto();
        if(detailPhotoPart != null && detailPhotoPart.getOriginalFilename() != null && detailPhotoPart.getOriginalFilename().length() > 0) {
            photoService.update(product, productVO, PhotoType.DETAIL);
        }
        
    }
    

    @Override
    public void updateProduct(ProductVO productVO) {
        ProductCategory pc = productCategoryDao.findProductCategoryByCategoryType(productVO.getCategoryType());
        
        Product product = productDao.findProductById(productVO.getProductId());
        product.setAbout(productVO.getAbout());
        product.setDescription(productVO.getDescription());
        product.setEnabled(productVO.isEnabled());
        product.setFeatures(productVO.getFeatures());
        product.setName(productVO.getName());
        product.setProductCategory(pc);
        product.setPrice(productVO.getPrice());
        product.setRecomended(productVO.getRecommended());
        product.setWeight(productVO.getWeight());
       
        productDao.update(product);
        
      //size
        sizeService.update(product, productVO);
//color        
        colorService.update(product, productVO);  
        
      //main photo
        MultipartFile photoPart = productVO.getPhoto();
        if(photoPart != null && photoPart.getOriginalFilename() != null && photoPart.getOriginalFilename().length() > 0) {
            photoService.update(product, productVO, PhotoType.MAIN);
        }
        //detail photo
        MultipartFile detailPhotoPart = productVO.getDetailPhoto();
        if(detailPhotoPart != null && detailPhotoPart.getOriginalFilename() != null && detailPhotoPart.getOriginalFilename().length() > 0) {
            photoService.update(product, productVO, PhotoType.DETAIL);            
        }


        
    }

    @Override
    public void updateCategory(ProductCategoryVO productCategoryVO) {
        ProductCategory productCategory = productCategoryDao.findProductCategoryById(productCategoryVO.getProductCatId());
        productCategory.setCategoryType(productCategoryVO.getCategoryType());
        productCategory.setName(productCategoryVO.getName());
        productCategory.setEnabled(productCategoryVO.isEnabled());
        productCategoryDao.update(productCategory);
    }

    @Override
    public String findCatNameById(String productCatId) {
        ProductCategoryVO pcVO = findCatById(productCatId);
        return pcVO.getName();
    }

    @Override
    public String findCatIdByCategoryType(CategoryType categoryType) {
        ProductCategory pc = productCategoryDao.findProductCategoryByCategoryType(categoryType);
        return pc.getProductCatId();
    }

}
