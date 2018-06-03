package com.main.MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by asus on 2017/3/19.
 * 1   AutomicInteger  AutomicBoolean ....  共享数据为基本数据类型时， 最好使用AutomicXXX，
 * 有相应的updater对对象的共享值进行操作（将对象和AutomicXXX传入updater）。
 * <p>
 * 2  线程池：
 * //只需把任务丢到线程池，让线程池自己去调度。
 * <p>
 * 3  线程池管理多个Timer
 */
public class Cocurrent_ThreadPool_008 {

    public static void main(String[] args) {
        //ThreadPoolTest();
        ThreadPoolTimerTest();


    }

    public static void ThreadPoolTimerTest() {
        //线程池启动定时器
        ScheduledExecutorService timerPool = Executors.newScheduledThreadPool(3);
        timerPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing one time");
            }
        }, 3, TimeUnit.SECONDS);
        timerPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing cycle");
            }
        }, 10, 5, TimeUnit.SECONDS);


    }

    public static void ThreadPoolTest() {
        //commited 10 threadtask, but only 3 can be in use.
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " is loop of " + j + " is task of " + task);
                    }
                }
            });
        }
        //任务完成，关闭线程池。
        threadPool.shutdown();

        //会根据任务自动扩充与收缩线程数
        ExecutorService threadPool1 = Executors.newCachedThreadPool();

        //单个线程，如果线程挂断，会启动一个替补
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
    }


}

