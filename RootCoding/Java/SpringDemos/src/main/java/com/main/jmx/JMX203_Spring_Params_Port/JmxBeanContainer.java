package com.main.jmx.JMX203_Spring_Params_Port;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by asus on 2016/12/1.
 */
public class JmxBeanContainer {
    private static JmxTestBean testBean;

    public static void main(String[] args) {
        BeanFactory f = new ClassPathXmlApplicationContext("classpath:com/resources/jmx/JMX203_Spring_Parms_Port/applicationContext_jmxSettingPortInParams.xml");
        //    JmxTestBean proxy = (JmxTestBean)f.getBean("testBean");


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
