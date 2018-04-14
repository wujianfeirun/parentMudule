package com.main.jmx.JMX204_Spring_Params_Port_In_Jvm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by asus on 2016/12/1.
 */
public class JmxBeanContainer1 {
    private static JmxTestBean testBean;

    public static void main(String[] args) {
        BeanFactory f = new ClassPathXmlApplicationContext("classpath:com/resources/jmx/JMX204_Spring_Params_Port_In_Jvm/applicationContext_jmxSettingPortInParams.xml");

        while (true) {
            if (testBean.getAge() < 10) {
                System.out.println("small");
            } else {
                System.out.println("big");
            }
        }
    }

    public JmxTestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(JmxTestBean testBean) {
        this.testBean = testBean;
    }

}
