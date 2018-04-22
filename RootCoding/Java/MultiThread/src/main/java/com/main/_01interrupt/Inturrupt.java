package com.main._01interrupt;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by asus on 2017/3/13.
 * 当执行执行interrupt时此线程正处于sleep状态，那么，将直接导致抛出 java.lang.InterruptedException: sleep interrupted
 * 并且不会重试
 */
public class Inturrupt extends Thread {

    @Override
    public void run() {
        while (! interrupted()){
            System.out.println(getName() + " do sth");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Inturrupt i1 = new Inturrupt();
        Inturrupt i2 = new Inturrupt();

        i1.start();
        i2.start();

        Thread.sleep(5500);
        i1.interrupt();

    }
}
