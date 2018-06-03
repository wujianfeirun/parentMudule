package com.main.MultiThread;

/**
 * Created by asus on 2017/3/13.
 */
public class ThreadCreate_001 {
    public static void main(String[] args) {
        //1 create child class
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("ThreadChild" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
        //2 implement runnable
        new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("runnable" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.run();

        //Runnable as param in Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Runnable to Thread" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
