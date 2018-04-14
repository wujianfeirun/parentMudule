package com.main.jmx.JMX201_Spring_RmiConnector_;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jmx.access.MBeanProxyFactoryBean;

/**
 * Created by asus on 2016/11/29.
 */
public class Client {
    public static void main(String[] args) {
        BeanFactory f = new ClassPathXmlApplicationContext("classpath:com/main/jmx/JMX201_Spring_RmiConnector/applicationContext_ServerConnector.xml");
        MBeanProxyFactoryBean proxy = (MBeanProxyFactoryBean) f.getBean("proxy");

        //proxy.invoke()
    }
}
