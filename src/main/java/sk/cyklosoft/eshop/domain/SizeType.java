package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sk.cyklosoft.eshop.vo.SizeVO;

@Entity
@Table(name = "SIZE_TYPE")
public class SizeType implements Serializable {
    
    private static final long serialVersionUID = -7197257911396481313L;


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;

    
    @Column(name = "value", nullable = false, columnDefinition = "varchar(32)")
    private String value;
    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
    }


    public SizeVO copy() {
        return new SizeVO(id, value);
    }
}
