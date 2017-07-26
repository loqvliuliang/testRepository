package com.example.demo.service.util;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ll on 2017/7/21.
 */


public class StringUtil {

    public static  String formatZonedTime(ZonedDateTime zonedDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        String str = zonedDateTime.format(formatter);
        return str;
    }
}
