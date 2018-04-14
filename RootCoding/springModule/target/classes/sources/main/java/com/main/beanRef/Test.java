package com.main.beanRef;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:com/resources/beanRef/spring_father2.xml");  
        Father father = (Father) applicationContext.getBean("bean_father");
        System.out.println(father.getName()  + "'s son is :"+ father.getSon().getName());
        
	}
}
