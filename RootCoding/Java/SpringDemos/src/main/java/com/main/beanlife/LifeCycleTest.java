package com.main.beanlife;

import org.springframework.context.Lifecycle;

/**
 * Created by asus on 2017/5/29.
 */
public class LifeCycleTest implements Lifecycle {
    public void start() {

    }

    public void stop() {

    }

    public boolean isRunning() {
        return false;
    }

    public static void main(String[] args) {

        System.out.println("LifeCycleTest.main");
    }
}
