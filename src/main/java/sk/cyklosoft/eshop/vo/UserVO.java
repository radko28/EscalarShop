package sk.cyklosoft.eshop.vo;

import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import sk.cyklosoft.eshop.domain.RoleType;


public class UserVO {
    
    private String userId;
    @Size(min=3, max=20)
    private String username; 
    private String lastname; 
    private String firstname;
    private String password; 
    private DateTime birthdate;
    private boolean enabled; 
    private RoleType authority;
    private String role;
    private String oldpassword;
    private String confirm;
    private String enabledValue;
    
    public UserVO(String userId, String username, String firstname, String lastname, String password, boolean enabled, RoleType authority) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname; 
        this.password= password; 
        setEnabled(enabled);
        setRole(authority.toString());
    }

    
    public UserVO() {
        // TODO Auto-generated constructor stub
    }


    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    public String getUsername() {
        return username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getLastname() {
        return lastname;
    }

    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public DateTime getBirthdate() {
        return birthdate;
    }

    
    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }

    
    public boolean isEnabled() {
        return enabled;
    }

    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        this.enabledValue = enabled ? "checked" : new String();
    }

    
    public RoleType getAuthorityType() {
        return authority;
    }

    public String getAuthority() {
        return authority.name();
    }

    
    public void setAuthority(RoleType authority) {
        this.authority = authority;
    }


    
    public String getFirstname() {
        return firstname;
    }


    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    
    public String getOldpassword() {
        return oldpassword;
    }


    
    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }


    
    public String getConfirm() {
        return confirm;
    }


    
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role != null && (role.equals("checked") || role.equals(RoleType.ROLE_ADMIN.toString()))) {
            this.role = "checked";
            this.authority = RoleType.ROLE_ADMIN;
        } else {
            this.role = new String();
            this.authority = RoleType.ROLE_USER;
        }
    }


    
    public String getEnabledValue() {
        return enabledValue;
    }


    
    public void setEnabledValue(String enabledValue) {
        this.enabledValue = enabledValue;
        if(enabledValue != null && enabledValue.equals("checked")) {
            this.enabled = true;
        } else {
            this.enabled = false;
        }
    }


}
