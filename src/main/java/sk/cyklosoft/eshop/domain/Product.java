package sk.cyklosoft.eshop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import sk.cyklosoft.eshop.util.Copyable;
import sk.cyklosoft.eshop.vo.ProductVO;

@Entity
public class Product implements Serializable, Copyable {

    private static final long serialVersionUID = -5329407144747618972L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "product_id", nullable = false, columnDefinition = "varchar(32)")
    private String productId;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64)")
    private String name;

     @Column(name = "enabled", nullable = false) 
     private boolean enabled;
     
     @Enumerated(EnumType.STRING)
     @Column(name = "recommended", nullable = true) 
     private RecommendedType recommended;
     
     @Column(name = "about", nullable = true) 
     private String about;
     
     @Column(name = "description", nullable = true) 
     private String description;
     
     @Column(name = "features", nullable = true) 
     private String features;

     @Column(name = "weight", nullable = true) 
     private int weight;
     
     @Column(name = "price", nullable = true) 
     private float price;

    
    @ManyToOne
    @JoinColumn(name = "product_cat_id")
    private ProductCategory productCategory;
    
    @OneToMany(mappedBy = "product")
    private List<Photo> photo;
    
    
    //TODO 9
  //  @OneToOne
   // @JoinColumn(name = "cart_id")
    @Transient
    private Cart cart;
    
    
    //TODO payment
   // @OneToOne
    //@JoinColumn(name = "order_id")
    @Transient
    private Order order;
    

    @OneToMany(mappedBy = "product")
    private List<Size> sizes;
     
    @OneToMany(mappedBy = "product")
    private List<Color> colors;
    

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public ProductVO copy() {
        return new ProductVO(productId, name,about, enabled,productCategory,recommended, 
                description, features, price, colors, weight, sizes);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }

    
   public String getFeatures() {
        return features;
    }

    
    public void setFeatures(String features) {
        this.features = features;
    }

    
    public String getAbout() {
        return about;
    }

    
    public void setAbout(String about) {
        this.about = about;
    }

    
    public RecommendedType getRecommended() {
        return recommended;
    }

    
    public void setRecomended(RecommendedType recommended) {
        this.recommended = recommended;
    }

    
    public float getPrice() {
        return price;
    }

    
    public void setPrice(float price) {
        this.price = price;
    }

    
    public Cart getCart() {
        return cart;
    }

    
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    
    public Order getOrder() {
        return order;
    }

    
    public void setOrder(Order order) {
        this.order = order;
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

    
    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
    public List<Photo> getPhoto() {
        return  photo;
    }


}
