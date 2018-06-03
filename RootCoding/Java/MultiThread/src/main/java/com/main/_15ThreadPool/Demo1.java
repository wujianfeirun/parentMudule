package com.main._15ThreadPool;

public class Demo1 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("wait for 5s ......");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (Thread.activeCount() >1){

        }
        System.out.println("finished");

    }

}
