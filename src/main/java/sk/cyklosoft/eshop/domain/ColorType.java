package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sk.cyklosoft.eshop.vo.ColorVO;

@Entity
@Table(name = "COLOR_TYPE")
public class ColorType implements Serializable {

    private static final long serialVersionUID = 6008574739978603410L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Column(name = "name", nullable = false, columnDefinition = "varchar(32)")
    private String name;
    
    @Column(name = "code", nullable = false)
    private String code;

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }


    public ColorVO copy() {
        return new ColorVO(id, name, code);
    }

}
