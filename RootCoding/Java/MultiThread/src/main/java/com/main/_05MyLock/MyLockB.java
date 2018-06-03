package com.main._05MyLock;

/**
 * 可重入,记录线程和加锁的次数
 */
public class MyLockB {

    private boolean isLocked;
    private Thread lockedBy;
    private int lockCount=0;

    public synchronized void lock() {

        while(isLocked && lockedBy!=Thread.currentThread() ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockedBy = Thread.currentThread();
        lockCount++;
        isLocked = true;
    }

    public synchronized void unlock() {
        if(lockedBy==Thread.currentThread()){
            lockCount --;
            if(lockCount==0){
                isLocked = false;
                notify();
            }
        }
    }

}
