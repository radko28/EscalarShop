package sk.cyklosoft.eshop.vo;


public class ColorVO {
    
    private String id;
    private String name;
    private String code;
    private String checked;
    
    public ColorVO(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        if(checked) {
            this.checked = "checked";    
        } else {
            this.checked = new String();
        }
    }

    

}
