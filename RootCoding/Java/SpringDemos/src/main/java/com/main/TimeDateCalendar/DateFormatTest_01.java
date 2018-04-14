package com.main.TimeDateCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * G 年代标志符
 * y 年
 * M 月
 * d 日
 * h 时 在上午或下午 (1~12)
 * H 时 在一天中 (0~23)
 * m 分
 * s 秒
 * S 毫秒
 * <p>
 * E 星期
 * D 一年中的第几天
 * F 一月中第几个星期几
 * w 一年中第几个星期
 * W 一月中第几个星期
 * a 上午 / 下午 标记符
 * k 时 在一天中 (1~24)
 * K 时 在上午或下午 (0~11)
 * <p>
 * z 时区
 */
public class DateFormatTest_01 {
    public static void main(String[] args) {
        String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z")).format(new Date());
        System.out.println(str);
        String str1 = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")).format(new Date());
        System.out.println(str1);
    }
}
