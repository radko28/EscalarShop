package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.PersistentDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import sk.cyklosoft.eshop.vo.CartVO;

@Entity
@Table(name = "CART")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 4519683911218285318L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "cart_id", nullable = false, columnDefinition = "varchar(32)")
    private String cartId;
    
    @Column(name = "amount", nullable = false)
    private int amount;
        
    //@ManyToOne
    //@JoinColumn(name = "user_id")
    private User user;
    
 //   @OneToOne(mappedBy = "cart")
    private Product product;
    
    @Column(nullable = false)
    @Type(type = "jodaDateTime")
    @DateTimeFormat(pattern = "d.M.yyyy")
    private DateTime date;


    
    public User getUser() {
        return user;
    }

    
    public void setUser(User user) {
        this.user = user;
    }

    
       
    public CartVO copy() {
        return new CartVO(cartId, product.copy(), amount,user);
    }


    
    public int getAmount() {
        return amount;
    }


    
    public void setAmount(int amount) {
        this.amount = amount;
    }


    
    public Product getProduct() {
        return product;
    }


    
    public void setProduct(Product product) {
        this.product = product;
    }


    
    public String getCartId() {
        return cartId;
    }


    
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


    
    public DateTime getDate() {
        return date;
    }


    
    public void setDate(DateTime date) {
        this.date = date;
    }


}
