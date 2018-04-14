package com.main.Log4j.Log4j_Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * Created by asus on 2016/12/25.
 */
public class LogTest {
    public static void main(String[] args) {
        String log4jConfPath = "C:\\Users\\asus\\git\\springBean\\src\\main\\java\\com\\main\\Log4j\\Log4j_Properties\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);  //log4j配置文件路径
        UserService us = new UserService();
        us.add();
    }
}
