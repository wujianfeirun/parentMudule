package com.main._02Create;

import java.util.Timer;
import java.util.TimerTask;

public class Timers {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时处理");
            }
        },0,1000);
    }

}
