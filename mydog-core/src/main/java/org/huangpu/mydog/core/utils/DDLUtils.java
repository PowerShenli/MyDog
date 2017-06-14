package org.huangpu.mydog.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shenli on 2017/6/11.
 */
public class DDLUtils {

    private static final Map<String,String> transMap = new HashMap<String,String>(){{
        put("String", "varchar");
        put("Integer", "int");
        put("Long", "long");
        put("Float", "float");
        put("Double", "double");
        put("Boolean", "tinyint");
        put("Date", "timestamp");
        put("byte[]", "blob");
        put("BigDecimal", "DECIMAL");
    }};

    public static String getTbName(String entityName) {
        return "tbl1"+entityName.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    public static String getColumnName(String fieldName){
        String s =  fieldName.replaceAll("[A-Z]","_$0").toLowerCase();
        return s.charAt(0) == '_'?s.substring(1):s;
    }

    public static String getColumnType(String filedType, Integer length) {
        return new StringBuilder(transMap.get(filedType)).append("(").append(length).append(")").toString();
    }

    public static String package2Path(String basePackage) {
        return basePackage.replaceAll("[.]","/");
    }

    public static String path2Package(String path){
        return path.replaceAll("/",".");
    }


}
