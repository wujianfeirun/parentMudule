package com.main._08Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ComplexProd {

    private int signal=0;
    Lock lock = new ReentrantLock();
    Condition condA = lock.newCondition();
    Condition condB = lock.newCondition();
    Condition condC = lock.newCondition();

    public void a(){
        lock.lock();
        if(signal!=0){
            try {
                condA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" a");
        signal++;
        condB.signal();
        lock.unlock();
    }
    public void b(){
        lock.lock();
        if(signal!=1){
            try {
                condB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" b");
        signal++;
        condC.signal();
        lock.unlock();
    }
    public void c(){
        lock.lock();
        if(signal!=2){
            try {
                condC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" c");
        signal=0;
        condA.signal();
        lock.unlock();
    }

}
