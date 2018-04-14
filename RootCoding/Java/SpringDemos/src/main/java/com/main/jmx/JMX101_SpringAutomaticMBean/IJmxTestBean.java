package com.main.jmx.JMX101_SpringAutomaticMBean;

/**
 * Created by asus on 2016/11/28.
 */
public interface IJmxTestBean {
    public int getAge();

    public void setAge(int age);

    public String getName();

    public void setName(String name);

    public int add(int x, int y);

    public void dontExposeMe();
}
