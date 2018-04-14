package com.main.TimeDateCalendar;

import java.sql.Time;
import java.util.Date;

/**
 * Created by asus on 2016/12/27.
 */
public class sqlTimeTest_04 {
    public static void main(String[] args) {
        //没有无参构造，必须用时间戳来构造
        Date date = new Date();
        Time time = new Time(date.getTime());
        System.out.println(time.getTime());
        System.out.println(time);
    }
}
