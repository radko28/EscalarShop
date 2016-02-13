package sk.cyklosoft.eshop.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.multipart.MultipartFile;

import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.Color;
import sk.cyklosoft.eshop.domain.Photo;
import sk.cyklosoft.eshop.domain.PhotoType;
import sk.cyklosoft.eshop.domain.ProductCategory;
import sk.cyklosoft.eshop.domain.RecommendedType;
import sk.cyklosoft.eshop.domain.Size;

/**
 * 
 * @author radko28
 * 
 */
public class ProductVO {

    private String productId;
    private String name;
    private MultipartFile detailPhoto;
    private MultipartFile photo;
    private String about;
    private boolean enabled;    
    private ProductCategory productCategory;
    private RecommendedType recommended; 
    private String description;
    private String features;
    private float price;
    private List<Color> colors;
    private List<Size> sizes;
    private String[] formColors;
    private String[] formSizes;
    private int weight;
    private CategoryType categoryType;
    private List<Photo> photoDB;
    private String mainBytes;
    private String detailBytes;
    private Map<PhotoType, String> photoBytes;
    
    

    public ProductVO(String productId, String name, String about, boolean enabled, ProductCategory productCategory, 
            RecommendedType recommended, String description, String features,float price, List<Color> colors, int weight, List<Size> sizes) {
        this.productId = productId;
        this.name = name;
        this.about = about;
        this.enabled = enabled;
        this.productCategory = productCategory;
        this.recommended = recommended;
        this.description = description;
        this.features = features;
        this.price = price;
        this.colors = colors;
        this.sizes = sizes;
        this.weight = weight;
        this.sizes = sizes;
    }

    public ProductVO() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    
    public String getAbout() {
        return about;
    }

    
    public void setAbout(String about) {
        this.about = about;
    }

    
    public boolean isEnabled() {
        return enabled;
    }

    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }

    
    public String getFeatures() {
        return features;
    }

    
    public void setFeatures(String features) {
        this.features = features;
    }

    
    public float getPrice() {
        return price;
    }

    
    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    public List<Size> getSizes() {
        return sizes;
    }

    
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    
    public List<Color> getColors() {
        return colors;
    }

    
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    
    public CategoryType getCategoryType() {
        return categoryType;
    }

    
    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    
    public RecommendedType getRecommended() {
        return recommended;
    }

    
    public void setRecommended(RecommendedType recommended) {
        this.recommended = recommended;
    }

    
    public MultipartFile getPhoto() {
        return photo;
    }

    
    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    
    public void setDetailPhoto(MultipartFile detailPhoto) {
        this.detailPhoto = detailPhoto;
    }

    
    public MultipartFile getDetailPhoto() {
        return detailPhoto;
    }

    
    public String[] getFormColors() {
        return formColors;
    }

    
    public void setFormColors(String[] formColors) {
        this.formColors = formColors;
    }

    
    public String[] getFormSizes() {
        return formSizes;
    }

    
    public void setFormSizes(String[] formSizes) {
        this.formSizes = formSizes;
    }

    
    public List<Photo> getPhotoDB() {
        return photoDB;
    }

    
    public void setPhotoDB(List<Photo> photoDB) {
        photoBytes = new HashMap<PhotoType, String>();
        for(Photo photo : photoDB) {
            if(photo.getPhotoType().equals(PhotoType.MAIN)) {
                photoBytes.put(PhotoType.MAIN, new String(Base64.encode(photo.getContent())));
                mainBytes = new String(Base64.encode(photo.getContent()));
            } else if(photo.getPhotoType().equals(PhotoType.DETAIL)) {
                photoBytes.put(PhotoType.DETAIL, new String(Base64.encode(photo.getContent())));
                detailBytes = new String(Base64.encode(photo.getContent()));
            }
        }
    }

    
    public Map<PhotoType, String> getPhotoBytes() {
        return photoBytes;
    }

    
    public String getMainBytes() {
        return mainBytes;
    }

    
    public void setMainBytes(String mainBytes) {
        this.mainBytes = mainBytes;
    }

    
    public String getDetailBytes() {
        return detailBytes;
    }

    
    public void setDetailBytes(String detailBytes) {
        this.detailBytes = detailBytes;
    }
    }
