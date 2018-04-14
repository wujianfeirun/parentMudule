package com.main.MultiThread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by asus on 2017/3/17.
 * jdk 提供的线程间共享数据的工具类，相当于一个set
 */
public class ThreadLocalTest_006 {
    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
    private static ThreadLocal<MyTreadScopeData> myThreadScopeData = new ThreadLocal<MyTreadScopeData>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    MyTreadScopeData scopeData = new MyTreadScopeData();
                    scopeData.setAge(new Random().nextInt());
                    scopeData.setName("aaa" + new Random().nextInt());
                    System.out.println(Thread.currentThread().getName() + "get data: " + data);
                    myThreadScopeData.set(scopeData);

                    new A().get();
                    new B().get();
                    new C().get();
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + "get data: " + data);
                    x.set(data);

                    new A().get();
                    new B().get();
                    new C().get();
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
/*
        while(true){
            data = new Random().nextInt();
            System.out.println( "random data: " + data);
            Thread.sleep(50);
        }*/
    }

    static class A {
        public void get() {
            //TODO get myScopeData from ThreadLocal object.  it Silly!!!!!!!!!!
            data = x.get();
            System.out.println("A from " + Thread.currentThread().getName() + "get data: " + data);
        }
    }

    static class B {
        public void get() {
            data = x.get();
            System.out.println("B from " + Thread.currentThread().getName() + "get data: " + data);
        }

    }

    static class C {
        public void get() {
            data = x.get();
            System.out.println("C from " + Thread.currentThread().getName() + "get data: " + data);
        }
    }
}


class MyTreadScopeData {
    private String name;
    private int age;
    private int property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }
}