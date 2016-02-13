package sk.cyklosoft.eshop.vo;

import sk.cyklosoft.eshop.domain.User;


public class CartVO {
    private String cartId;
    private ProductVO product;
    private User user;
    private int amount;
    private float price;
    private int colour;
    private int size;

    public CartVO(String id, ProductVO product, int amount, User user) {
        this.cartId = id;
        this.product = product;
        this.user = user;
        this.amount = amount;
    }


    public String getCartId() {
        return cartId;
    }

    
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    
    public User getUser() {
        return user;
    }

    
    public void setUser(User user) {
        this.user = user;
    }

    
    public int getAmount() {
        return amount;
    }

    
    public void setAmount(int amount) {
        this.amount = amount;
    }


    
    public ProductVO getProduct() {
        return product;
    }


    
    public void setProduct(ProductVO product) {
        this.product = product;
    }


    
    public float getPrice() {
        return price;
    }


    
    public void setPrice(float price) {
        this.price = price;
    }


    
    public int getColour() {
        return colour;
    }


    
    public void setColour(int colour) {
        this.colour = colour;
    }


    
    public int getSize() {
        return size;
    }


    
    public void setSize(int size) {
        this.size = size;
    }

    
   
}
