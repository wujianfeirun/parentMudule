package com.main.jmx.JMX100_SpringJmx;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by asus on 2016/11/29.
 */
public class Client {
    public static void main(String[] args) {
        BeanFactory f = new ClassPathXmlApplicationContext("classpath:com/main/jmx/JMX100_SpringJmx/applicationContext_jmxTestBean.xml");
        JmxTestBean proxy = (JmxTestBean) f.getBean("testBean");
        while (true) {

        }
        //proxy.invoke()
    }
}
