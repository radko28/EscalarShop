package sk.cyklosoft.eshop.domain;

import java.util.LinkedHashMap;
import java.util.Map;


public enum RecommendedType {

    ESCALAR("Escalar"),
    CORRER("Correr");


    private String value;
    
    RecommendedType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Map<RecommendedType, String> getRecommendedTypeMap() {
        Map<RecommendedType, String> recommendedTypeMap = new LinkedHashMap<RecommendedType, String>();
        for(RecommendedType type:RecommendedType.values()) {
            recommendedTypeMap.put(type, type.getValue());
        }
        return recommendedTypeMap;
    }

}
