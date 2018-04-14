package com.main.Time8;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by asus on 2017/6/18.
 * java8 之前的time问题：
 * Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。
 * java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * 对于时间、时间戳、格式化以及解析，并没有一些明确定义的类。对于格式化和解析的需求，我们有java.text.DateFormat抽象类，但通常情况下，SimpleDateFormat类被用于此类需求。
 * 所有的日期类都是可变的，因此他们都不是线程安全的，这是Java日期类最大的问题之一。
 * 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 *
 * java8修正的问题：
 * 不变性：新的日期/时间API中，所有的类都是不可变的，这对多线程环境有好处。
 * 关注点分离：新的API将人可读的日期时间和机器时间（unix timestamp）明确分离，它为日期（Date）、时间（Time）、日期时间（DateTime）、时间戳（unix timestamp）以及时区定义了不同的类。
 * 清晰：在所有的类中，方法都被明确定义用以完成相同的行为。举个例子，要拿到当前实例我们可以使用now()方法，在所有的类中都定义了format()和parse()方法，而不是像以前那样专门有一个独立的类。
 *      为了更好的处理问题，所有的类都使用了工厂模式和策略模式，一旦你使用了其中某个类的方法，与其他类协同工作并不困难。
 * 实用操作：所有新的日期/时间API类都实现了一系列方法用以完成通用的任务，如：加、减、格式化、解析、从日期/时间中提取单独部分，等等。
 * 可扩展性：新的日期/时间API是工作在ISO-8601日历系统上的，但我们也可以将其应用在非IOS的日历上。
 *
 * 注意点
 *  由于变量不可变，进行变化时需要用新的变量接收    LocalTime newTime = oldtime.plusHours(2);
 */
public class TimeJava8 {
    public static void main(String[] args) {
       // testLocalDate();
       // LocalTimeExample();


        //默认 yyyy-MM-ddTHH-mm-ss.zzz
        LocalDateTimeExample();

        //统一的 parse   format方法   借助 DateTimeFormatter.ofPattern("d::MMM::uuuu")进行转换
        DateParseFormatExample();
    }

    public static void LocalDateExample() {

        //Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date="+today);

        //Creating LocalDate by providing input arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date="+firstDay_2014);

        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);


        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST="+todayKolkata);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date= "+dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014="+hundredDay2014);
    }
    public static void LocalTimeExample() {

            //Current Time
            LocalTime time = LocalTime.now();
            System.out.println("Current Time="+time);

            //Creating LocalTime by providing input arguments
            LocalTime specificTime = LocalTime.of(12,20,25,40);
            System.out.println("Specific Time of Day="+specificTime);

            //Try creating time by providing invalid inputs
            //LocalTime invalidTime = LocalTime.of(25,20);

            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
            System.out.println("Current Time in IST="+timeKolkata);


            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalTime shanghaiTime = LocalTime.now(ZoneId.of("Asia/Shanghai"));
            System.out.println("Current Date in CTT="+shanghaiTime);


            //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
            //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

            //Getting date from the base date i.e 01/01/1970
            LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
            System.out.println("10000th second time= "+specificSecondTime);

        }


    public static void LocalDateTimeExample() {


            //Current Date
            LocalDateTime today = LocalDateTime.now();
            System.out.println("Current DateTime="+today);

            //Current Date using LocalDate and LocalTime
            today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
            System.out.println("Current DateTime="+today);

            //Creating LocalDateTime by providing input arguments
            LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
            System.out.println("Specific Date="+specificDate);

            //Try creating date by providing invalid inputs
            //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);

            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
            System.out.println("Current Date in IST="+todayKolkata);

            //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
            //LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

            //Getting date from the base date i.e 01/01/1970
            LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
            System.out.println("10000th second time from 01/01/1970= "+dateFromBase);

        }

    public static void  DateParseFormatExample() {
            //Format examples
            LocalDate date = LocalDate.now();
            //default format
            System.out.println("Default format of LocalDate="+date);
            //specific format
            System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
            System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

            LocalDateTime dateTime = LocalDateTime.now();
            //default format
            System.out.println("Default format of LocalDateTime="+dateTime);
            //specific format
            System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
            System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

            Instant timestamp = Instant.now();
            //default format
            System.out.println("Default format of Instant="+timestamp);

            //Parse examples
            LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
                    DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
            System.out.println("Default format after parsing = "+dt);
        }

}
