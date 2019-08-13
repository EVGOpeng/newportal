package com.calabar.portal.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParametersUtil {
   public static Map setparatersToMap(Long siteId,String title,String minTime,Long resId,
                                      Integer ispublish,String maxTime){
        Map map=new HashMap<String,Object>();
        map.put("siteId", siteId);
        if(StringUtils.isNotEmpty(title)){ map.put("title", title);}
        if(StringUtils.isNotEmpty(minTime)){
            Date minDate = DateUtil.paresDate(minTime);
            if(StringUtils.isNotEmpty(minDate))
                map.put("minDate", minDate);
        }
        if(StringUtils.isNotEmpty(maxTime)){
            Date maxDate = DateUtil.paresDate(maxTime);
            if(StringUtils.isNotEmpty(maxDate))
                map.put("maxDate", maxDate);
        }
        if(StringUtils.isNotEmpty(resId)){map.put("resId", resId);}
        if(StringUtils.isNotEmpty(ispublish)){map.put("ispublish", ispublish);}
        return map;
    }
}
