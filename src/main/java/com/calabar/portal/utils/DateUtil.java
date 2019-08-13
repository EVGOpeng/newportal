package com.calabar.portal.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static  SimpleDateFormat sdfm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date paresDate(String date){
        try {
            return sdfm.parse(date);
        }catch (Exception e){
            return null;
        }
    }
}
