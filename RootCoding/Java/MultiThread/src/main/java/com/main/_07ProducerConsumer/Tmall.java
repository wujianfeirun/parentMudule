package com.main._07ProducerConsumer;

public class Tmall {
    private int MAX_CONUT=10;
    private int count=0;

    public synchronized void push(){
        while(count>=MAX_CONUT){
            try {
                System.out.println(Thread.currentThread().getName()+"库存已满，等待消费");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count ++;
        System.out.println(Thread.currentThread().getName()+"库存已达"+count);
        notifyAll();
    }

    public synchronized void take(){
        while(count==0){
            try {
                System.out.println(Thread.currentThread().getName()+"消费者等待生产");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        System.out.println(Thread.currentThread().getName()+"库存减至"+count);
        notifyAll();
    }


}
