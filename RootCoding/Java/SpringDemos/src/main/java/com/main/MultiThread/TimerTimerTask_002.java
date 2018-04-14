package com.main.MultiThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by asus on 2017/3/13.
 * 定时器调度定时任务
 * 定时任务一旦scheduled或者cancelled，就不能再被使用
 * <p>
 * 开源工具quartz进行定时处理
 */
public class TimerTimerTask_002 {

    public static void main(String[] args) throws InterruptedException {
        //for one time
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing1!");
            }
        }, 3000);

        //Timed call ever 1s
/*        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.println("bombing2!");
            }
        },3000,1000);*/

        //Timed call ever 2s 4s  2s 4s ...
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing3!");
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("bombing4!");
                    }
                }, 2000);
            }
        }, 1000, 6000);
        int i = 0;
        while (true) {
            Thread.sleep(1000);
            System.out.println(++i);
        }
    }


}
