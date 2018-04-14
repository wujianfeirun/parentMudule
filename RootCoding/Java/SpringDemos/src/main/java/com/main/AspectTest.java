package com.main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class AspectTest{
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("aop/bean.xml");
        Action  o= (Action) ac.getBean(Action.class);
        o.actionSth();
    }
}
@Component
class Action{
    public String actionSth(){
        System.out.println("actionsth");
        return "";
    }
}

@Component
@Aspect
class ActionAspect {
    @Pointcut("execution(* com.main.Action*.*(..))")
    public void performance(){};

    @Before("performance()")
    public void before(){
        System.out.println("before");
    }

    @AfterReturning("performance()")
    public void afterReturning(){
        System.out.println("afterReturning");
    }

    @After("performance()")
    public void after(){
        System.out.println("after");
    }

    @Around("performance()")
    public Object around(ProceedingJoinPoint joinPoint){

        Object obj = null ;
        try {
            System.out.println("arrount in");
            obj = joinPoint.proceed();
            System.out.println("arrount out");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }
}






