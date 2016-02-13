package sk.cyklosoft.eshop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.PersistentDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SUMMARY_ORDER")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class SummaryOrder implements Serializable {

    private static final long serialVersionUID = -422747053851546033L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "summary_order_id", nullable = false, columnDefinition = "varchar(32)")
    private String summaryOrderId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "orderType", nullable = true, columnDefinition = "varchar(20)")
    private OrderType orderType;
    
    @OneToMany(mappedBy = "summaryOrder")
    private List<Order> orders;
    
    @Column(name = "price", nullable = true) 
    private float price;
    
    @OneToOne(mappedBy = "summaryOrder")
    private Factura factura;
    
    @Column(nullable = false)
    @Type(type = "jodaDateTime")
    @DateTimeFormat(pattern = "d.M.yyyy")
    private DateTime date;

    
    public String getSummaryOrderId() {
        return summaryOrderId;
    }

    
    public void setSummaryOrderId(String summaryOrderId) {
        this.summaryOrderId = summaryOrderId;
    }

    
    public OrderType getOrderType() {
        return orderType;
    }

    
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    
    public List<Order> getOrders() {
        return orders;
    }

    
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    
    public float getPrice() {
        return price;
    }

    
    public void setPrice(float price) {
        this.price = price;
    }

    
    public Factura getFactura() {
        return factura;
    }

    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
    public DateTime getDate() {
        return date;
    }

    
    public void setDate(DateTime date) {
        this.date = date;
    }


    
}
