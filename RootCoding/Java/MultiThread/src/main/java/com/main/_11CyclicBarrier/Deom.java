package com.main._11CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Deom {

    public void attendClass(CyclicBarrier barrier,int i){
        System.out.println(Thread.currentThread().getName()+" 学号"+i+"报名上课");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();           //线程阻塞在此，阻塞线程数加法计算；
                                       // 直到达到数目，阻塞的线程被释放执行 ，计数器重置为0

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 学号"+i+"开始听课");
    }


    public static void main(String[] args) {
        Deom demo = new Deom();
        int STUDENT_NUM = 20;
        CyclicBarrier barrier = new CyclicBarrier(STUDENT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("人数到齐，开始培训");
            }
        });
        for (int i = 0; i <STUDENT_NUM*2+3 ; i++) {
            int j=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.attendClass(barrier,j);
                }
            }).start();
        }
    }

}
