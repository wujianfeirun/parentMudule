package com.main.MultiThread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by asus on 2017/3/17.
 * <p>
 * 使得变量在线程内共享，在线程间是独立的
 */
public class ThreadScopeSharedData__005 {
    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<Thread, Integer>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + "get data: " + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                    new C().get();
//sleep here is diff with below ， the output show AABBCC, the below show ABCABC, for is not in sequence
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
            data = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() + "get data: " + data);
        }
    }

    static class B {
        public void get() {
            data = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() + "get data: " + data);
        }

    }

    static class C {
        public void get() {
            data = threadData.get(Thread.currentThread());
            System.out.println("C from " + Thread.currentThread().getName() + "get data: " + data);
        }
    }
}
