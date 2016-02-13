package sk.cyklosoft.eshop.domain;

import java.util.LinkedHashMap;
import java.util.Map;


public enum PhotoType {

    MAIN("Main"),
    DETAIL("Detail");


    private String value;
    
    PhotoType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Map<PhotoType, String> getPhotoTypeMap() {
        Map<PhotoType, String> photoTypeMap = new LinkedHashMap<PhotoType, String>();
        for(PhotoType type:PhotoType.values()) {
            photoTypeMap.put(type, type.getValue());
        }
        return photoTypeMap;
    }

}

