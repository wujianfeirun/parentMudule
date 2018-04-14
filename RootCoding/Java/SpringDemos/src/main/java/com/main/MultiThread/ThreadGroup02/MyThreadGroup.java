package com.main.MultiThread.ThreadGroup02;

/**
 * ThreadGroup  主要用于： 1 获取组中活跃的线程列表 activeCount()
 *                         2  设置未捕获处理器 uncaughtException()
 *                         3， interrupt()
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();

    }
}
