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

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 2646683474075646849L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Column(name = "address", nullable = false, columnDefinition = "varchar(64)")
    private String address;
    
    @Column(name = "zip", nullable = false, columnDefinition = "varchar(64)")
    private String zip;
    
    @Column(name = "city", nullable = false, columnDefinition = "varchar(64)")
    private String city;
    
    @Column(name = "country", nullable = false, columnDefinition = "varchar(64)")
    private String country;
    
    @Column(name = "phone", nullable = false, columnDefinition = "varchar(64)")
    private String phone;
    
    @Column(name = "company", nullable = false, columnDefinition = "varchar(64)")
    private String company;
    
    @Column(name = "company_id", nullable = false, columnDefinition = "varchar(64)")
    private String companyId;
    
    @Column(name = "account_number", nullable = false, columnDefinition = "varchar(64)")
    private String accountNumber;
    
    @Column(name = "account_number_inter", nullable = false, columnDefinition = "varchar(64)")
    private String accountNumberInter;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getZip() {
        return zip;
    }

    
    public void setZip(String zip) {
        this.zip = zip;
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city;
    }

    
    public String getCountry() {
        return country;
    }

    
    public void setCountry(String country) {
        this.country = country;
    }

    
    public String getPhone() {
        return phone;
    }

    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public String getCompany() {
        return company;
    }

    
    public void setCompany(String company) {
        this.company = company;
    }

    
    public String getCompanyId() {
        return companyId;
    }

    
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    
    public String getAccountNumberInter() {
        return accountNumberInter;
    }

    
    public void setAccountNumberInter(String accountNumberInter) {
        this.accountNumberInter = accountNumberInter;
    }
    
    
    

}
