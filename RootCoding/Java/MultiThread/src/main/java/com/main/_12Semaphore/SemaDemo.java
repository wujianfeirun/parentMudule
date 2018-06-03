package com.main._12Semaphore;

import java.util.concurrent.Semaphore;

public class SemaDemo {

    public void method(Semaphore semaphore){
        try {
            semaphore.acquire();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is running....");

        semaphore.release();
    }


    public static void main(String[] args) {
        SemaDemo demo = new SemaDemo();
        Semaphore sp = new Semaphore(10);
        int i = 0;
        while (i<105){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.method(sp);

                }
            }).start();
            i++;
        }
    }
}
