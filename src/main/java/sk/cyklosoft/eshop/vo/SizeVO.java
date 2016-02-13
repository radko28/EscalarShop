package sk.cyklosoft.eshop.vo;


public class SizeVO {

    private String id;
    private String value;
    private String checked;
    
    public SizeVO(String id, String value) {
        this.id = id;
        this.value = value;
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
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
