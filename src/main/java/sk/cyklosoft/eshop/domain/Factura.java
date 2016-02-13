package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "FACTURA")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class Factura implements Serializable {
    
    private static final long serialVersionUID = -452130199835783505L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Column(nullable = false)
    @Type(type = "jodaDateTime")
    @DateTimeFormat(pattern = "d.M.yyyy")
    private DateTime date;
    
    @OneToOne
    @JoinColumn(name = "summary_order_id")
    private SummaryOrder summaryOrder;
    
    
    @Column(name = "file_name", nullable = false)
    private String fileName;
    
      
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
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


    
    public String getFileName() {
        return fileName;
    }


    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
