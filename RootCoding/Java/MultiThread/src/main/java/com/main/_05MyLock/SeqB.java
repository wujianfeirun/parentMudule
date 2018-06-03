package com.main._05MyLock;

public class SeqB {
    private int num = 0;
    MyLockB lock = new MyLockB();

    public int getNextNum() throws InterruptedException {
        lock.lock();
        nextLockMethod();
        Thread.sleep(10);
        num ++;
        lock.unlock();
        return num;
    }

    public void nextLockMethod(){
        lock.lock();
        lock.unlock();
    }


    public static void main(String[] args) {
        SeqB seq = new SeqB();
        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(seq.getNextNum());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(seq.getNextNum());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
