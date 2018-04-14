package com.main.MultiThread;

import java.util.Random;

/**
 * Created by asus on 2017/3/17.
 * <p>
 * TODO Runtime.addShutdownHook(Runnable)  JVM down hook， can add action when JVM shutdown。
 * <p>
 * 、、
 */
public class ThreadLocalTest_007 {
    private static ThreadLocal<MyTreadScopeData1> myThreadScopeData = new ThreadLocal<MyTreadScopeData1>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + "get data: " + data);
                    MyTreadScopeData1.getInstance1().setAge(data);
                    MyTreadScopeData1.getInstance1().setName("name" + data);

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

    static class A {
        public void get() {
            //TODO get myScopeData from ThreadLocal object.  it Silly!!!!!!!!!!

            System.out.println("A from " + Thread.currentThread().getName() + "get data: " + MyTreadScopeData1.getInstance1().getAge());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + "get data: " + MyTreadScopeData1.getInstance1().getAge());
        }

    }

    static class C {
        public void get() {
            System.out.println("C from " + Thread.currentThread().getName() + "get data: " + MyTreadScopeData1.getInstance1().getAge());
        }
    }

}


class MyTreadScopeData1 {
    //singleton  keep only one instance in service
/*    private MyTreadScopeData1(){
    }
    public static MyTreadScopeData1 getInstance(){
        return instance;
    }
    private static MyTreadScopeData1 instance = new MyTreadScopeData1();*/

    private static MyTreadScopeData1 instance = null;
    private static ThreadLocal<MyTreadScopeData1> map = new ThreadLocal<MyTreadScopeData1>();
    private String name;
    private int age;
    private int property;

    //Lazy type,Under normal circumstances， it need synchronized
    //static ThreadLocal be hided in MyTreadScopeData1, it must be static to keep it single
    public static /*synchronized*/ MyTreadScopeData1 getInstance1() {
        instance = map.get();
        if (instance == null) {
            instance = new MyTreadScopeData1();
            map.set(instance);
        }
        return instance;
    }

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
