package com.main.TimeDateCalendar;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by asus on 2016/12/27.
 */
public class joda_DateTimeTest_05 {
    public static void main(String[] args) {
        //日期+时间:  *****无需format，直接转化为string*****
        DateTime dateTime = new DateTime();
        System.out.println("1:  " + dateTime);    //显示毫秒,显示+08:00
        System.out.println("2:  " + dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        //本地日期
        LocalDate localDate = new LocalDate();
        System.out.println("3:  " + localDate);
        //本地时间
        LocalTime localTime = new LocalTime();
        System.out.println("4:  " + localTime.toString("HH:mm:ss"));
        //本地日期+时间
        LocalDateTime localDateTime = new LocalDateTime();
        System.out.println("5:  " + localDateTime);   //不显示+08:00

        //转换java.util.Date
        Date date = new Date();
        DateTime datetime = new DateTime(date);   //构造
        Date date1 = dateTime.toDate();

        //转换java.util.Calendar
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime1 = new DateTime(calendar);
        Calendar calendar1 = dateTime1.toCalendar(Locale.CHINESE);


    }
}
