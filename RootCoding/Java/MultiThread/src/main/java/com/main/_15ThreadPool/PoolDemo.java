package com.main._15ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolDemo {

    public static void main(String[] args) {
        //TODO 饱和策略
        ThreadPoolExecutor.CallerRunsPolicy policy =  new ThreadPoolExecutor.CallerRunsPolicy();        //线程池和queue都满了的时候交给当前线程【main】来处理。
        ThreadPoolExecutor.DiscardOldestPolicy policy1 = new ThreadPoolExecutor.DiscardOldestPolicy();  //丢弃最新的一个任务

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,10, TimeUnit.HOURS,new ArrayBlockingQueue<>(10),policy);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i <100 ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    count.getAndIncrement();
                }
            });
        }
        threadPool.shutdown();     //只有已提交的线程任务全部执行完毕才会shutDown

        System.out.println("调用次数:"+count.get());
    }

}
