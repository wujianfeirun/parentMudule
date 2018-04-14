package com.main.jmx.JMX005_JMX_commons_modeler;

import com.main.jmx.JMX002_JdkJmx.HelloMBean;

public class Hello implements HelloMBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello World, " + name);
    }

    public void printHello(String whoName) {
        System.out.println("Hello , " + whoName);
    }
}