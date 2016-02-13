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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.PersistentDateTime;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 
 * objednavky - nevybavene(neodoslane, zaplatene/nezaplatene, odoslana faktura)
 * 
 * @author radko28
 *
 */
@Entity
@Table(name = "ORDER")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class Order implements Serializable {

    private static final long serialVersionUID = -8264676211755220675L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "order_id", nullable = false, columnDefinition = "varchar(32)")
    private String orderId;
    
   // @OneToOne(mappedBy = "order")
    private User user;
    
    @Column(name = "amount", nullable = false)
    private int amount;
    
   // @OneToOne(mappedBy = "order")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "summary_order_id")
    private SummaryOrder summaryOrder;
    
    @Column(nullable = false)
    @Type(type = "jodaDateTime")
    @DateTimeFormat(pattern = "d.M.yyyy")
    private DateTime date;

    
    public String getOrderId() {
        return orderId;
    }

    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    
    public Product getProduct() {
        return product;
    }

    
    public void setProduct(Product product) {
        this.product = product;
    }

    
    public SummaryOrder getSummaryOrder() {
        return summaryOrder;
    }

    
    public void setSummaryOrder(SummaryOrder summaryOrder) {
        this.summaryOrder = summaryOrder;
    }

    
    public DateTime getDate() {
        return date;
    }

    
    public void setDate(DateTime date) {
        this.date = date;
    }


}
