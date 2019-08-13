package com.calabar.portal.utils;

public class StringUtils {
    public static boolean isEmpty(Object str){
    if(str==null||"".equals(str)){
        return true;
    }
    else return false;
    }
        public static boolean isNotEmpty(Object str){
        return !isEmpty(str);
    }
    public static String removeBlank(String str){
        if(isNotEmpty(str))
            return str.replace(" ", "").replace("   ", "");
        else
            return null;
    }
    public static boolean isNotBlank(String str){
        if(isNotEmpty(str))
            str= str.replace(" ", "").replace("   ", "");
        if(isNotEmpty(str))
            return true;
        return false;
    }
}
