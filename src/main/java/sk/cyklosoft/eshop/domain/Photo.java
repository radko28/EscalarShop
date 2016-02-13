package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Photo  implements Serializable {
    
    private static final long serialVersionUID = -8904192725783986281L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "photo_id", nullable = false, columnDefinition = "varchar(32)")
    private String photoId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "photoType", nullable = true) 
    private PhotoType photoType;
    
    @Column(name = "name", nullable = true)
    private String name;
    
    @Column(name = "mimeContentType", nullable = true)
    private String mimeContentType;
    
    @Lob
    @Type(type="org.hibernate.type.PrimitiveByteArrayBlobType")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = true)
    private byte[] content;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public String getPhotoId() {
        return photoId;
    }

    
    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    
    public PhotoType getPhotoType() {
        return photoType;
    }

    
    public void setPhotoType(PhotoType photoType) {
        this.photoType = photoType;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getMimeContentType() {
        return mimeContentType;
    }

    
    public void setMimeContentType(String mimeContentType) {
        this.mimeContentType = mimeContentType;
    }

    
    public byte[] getContent() {
        return content;
    }

    
    public void setContent(byte[] content) {
        this.content = content;
    }

    
    public Product getProduct() {
        return product;
    }

    
    public void setProduct(Product product) {
        this.product = product;
    }

}
