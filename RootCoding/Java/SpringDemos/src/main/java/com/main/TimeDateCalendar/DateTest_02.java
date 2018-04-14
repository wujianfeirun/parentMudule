package com.main.TimeDateCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2016/12/25.
 */
public class DateTest_02 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        long times = date.getTime();
        System.out.println(times);    //timestamp 时间戳
        java.sql.Date sqldate = new java.sql.Date(times);   //util.Date 转化为sql.Date

        times = 1412654676572L;
        date = new Date(times);
        System.out.println(date);   //时间戳转化为时间


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);     //格式化时间
        System.out.println(dateString);

        String dateStr = "2016-11-11 11:11:11";
        date = formatter.parse(dateStr);        //字符串转化为时间
        System.out.println(date);


    }
}
