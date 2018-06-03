package com.main.MultiThread;/*
package com.main.MultiThread;

*/
/**
 * Created by asus on 2017/3/17.
 * 直接把Class用来同步会让所有的线程都进行同步，把需要同步的业务集中到一个类中,降低同步的粒度
 *//*

public class SynchronizeResource_004 {

    public static void main(String[] args) {
        Business  business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <50 ; i++) {
                    business.sub();
                }
            }
        }).start();

        for (int i = 0; i <50 ; i++) {
            business.main();
        }
    }
}


class Business {
    public synchronized void main(){
        for (int i = 0; i < 50; i++) {
            System.out.println("main Thread is running "+i);
        }
    }
    public synchronized void sub(){
        for (int i = 0; i < 20; i++) {
            System.out.println("sub Thread is running "+i);
        }

    }
}

class Business2 {
    private boolean shouldSub = true;
    public synchronized void main() throws InterruptedException {
        if(shouldSub){
            this.wait();
        }
        for (int i = 0; i < 50; i++) {
            System.out.println("main Thread is running "+i);
        }
        shouldSub=true;
        this.notify();   //if without notify, may lead to wait all the time.
    }
    public synchronized void sub() throws InterruptedException {
        if(!shouldSub){
            this.wait();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("sub Thread is running "+i);
        }
        shouldSub=false;
        this.notify();
    }
}
//while replace if , multi-check wakeup condition or avoid spurious wakeup (伪唤醒，未唤自己醒来)
class Business3 {
    private boolean shouldSub = true;
    public synchronized void main() throws InterruptedException {
        while(shouldSub){
            this.wait();
        }
        for (int i = 0; i < 50; i++) {
            System.out.println("main Thread is running "+i);
        }
        shouldSub=true;
        this.notify();   //if without notify, may lead to wait all the time.
    }
    public synchronized void sub() throws InterruptedException {
        while(!shouldSub){
            this.wait();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("sub Thread is running "+i);
        }
        shouldSub=false;
        this.notify();
    }
}*/
