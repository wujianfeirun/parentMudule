package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.main.EnumGenerics.Colors;
import com.main.beanRef.Father;

public class TestSpring {
	public ApplicationContext applicationContext;
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:com/tstresources/*/*.xml");  
	}

	@After
	public void tearDown() throws Exception {
		applicationContext=null;
	}

	@Test
	public void testEnum() {
		Father father = (Father) applicationContext.getBean("bean_father");
        System.out.println(father.getName()  + "'s son is :"+ father.getSon().getName());
	/*	Colors colors = (Colors) applicationContext.getBean("enum_color");
		System.out.println(colors.BLACK)*/;
	}

}
