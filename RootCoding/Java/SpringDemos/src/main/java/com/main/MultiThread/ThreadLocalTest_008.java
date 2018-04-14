package com.main.MultiThread;


import java.nio.CharBuffer;

/**
 * main 中的变量和Thread-0中的变量不是同一份，证明了副本的存在
 */
public class ThreadLocalTest_008 {
      
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();  
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();  
  
    public void set() {  
        longLocal.set(Thread.currentThread().getId());  
        stringLocal.set(Thread.currentThread().getName());  
    }  
  
    public long getLong() {  
        return longLocal.get();  
    }  
  
    public String getString() {  
        return stringLocal.get();  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        final ThreadLocalTest_008 test = new ThreadLocalTest_008();

        test.set();  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
  
        Thread thread1 = new Thread() {  
            public void run() {
                //如果注释掉此处的test.set()，会报错。
                test.set();
                System.out.println(test.getLong());  
                System.out.println(test.getString());  
            };  
        };  
        thread1.start();  
        thread1.join();  
  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
    }  
}  