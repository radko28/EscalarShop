package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SIZE")
public class Size implements Serializable {

    private static final long serialVersionUID = -7280584250035304563L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Column(name = "value", nullable = false, columnDefinition = "varchar(32)")
    private String value;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    
    public Product getProduct() {
        return product;
    }

    
    public void setProduct(Product product) {
        this.product = product;
    }


    
    public String getValue() {
        return value;
    }


    
    public void setValue(String value) {
        this.value = value;
    }

}
