package com.main._02Create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建时会初始化一些线程；
 * 提交Task是向线程池申请线程
 * 线程池不会主动关闭，会一直等待
 */

public class Executortest {

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i <100 ; i++) {
            es.submit(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" doing sth");
                }
            });
        }


        //need to stop threadPool
        es.shutdown();


    }

}
