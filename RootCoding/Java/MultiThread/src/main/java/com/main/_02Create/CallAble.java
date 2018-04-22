package com.main._02Create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *  Callable  是异步，并且带返回值
 *  是对Runnable的扩展；
 */

public class CallAble implements Callable<Integer> {


    public static void main(String[] args) {
        CallAble ca = new CallAble();
        FutureTask<Integer> ft = new FutureTask<Integer>(ca);
        Thread th = new Thread(ft);
        th.start();
        System.out.println("do other thing");
    }

    public Integer call() throws Exception {
        System.out.println("caculating.....");
        Thread.sleep(1000);
        return 1;
    }
}
