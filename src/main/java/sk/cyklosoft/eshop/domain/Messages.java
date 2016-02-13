package sk.cyklosoft.eshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

@Entity
@Table(name = "MESSAGES")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class Messages implements Serializable {
    
    private static final long serialVersionUID = 5944349248205534790L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
    private String id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "emailType", nullable = true, columnDefinition = "varchar(20)")
    private EmailType emailType;
    
    @Column(name = "subject", nullable = false, columnDefinition = "varchar(32)")
    private String subject;
    
    @Column(name = "greeting", nullable = false, columnDefinition = "varchar(32)")
    private String greeting;
    
    @Column(name = "body", nullable = false, columnDefinition = "varchar(32)")
    private String body;
    
    @Column(name = "good_bye", nullable = false, columnDefinition = "varchar(32)")
    private String goodBye;
    
    @Column(name = "footer", nullable = false, columnDefinition = "varchar(32)")
    private String footer;
    
    @Column(nullable = false)
    @Type(type = "jodaDateTime")
    @DateTimeFormat(pattern = "d.M.yyyy")
    private DateTime date;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getSubject() {
        return subject;
    }

    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    public String getGreeting() {
        return greeting;
    }

    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    
    public String getBody() {
        return body;
    }

    
    public void setBody(String body) {
        this.body = body;
    }

    
    public String getGoodBye() {
        return goodBye;
    }

    
    public void setGoodBye(String goodBye) {
        this.goodBye = goodBye;
    }

    
    public String getFooter() {
        return footer;
    }

    
    public void setFooter(String footer) {
        this.footer = footer;
    }


    
    public EmailType getEmailType() {
        return emailType;
    }


    
    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }


    
    public DateTime getDate() {
        return date;
    }


    
    public void setDate(DateTime date) {
        this.date = date;
    }


    
    public User getUser() {
        return user;
    }


    
    public void setUser(User user) {
        this.user = user;
    }

}
