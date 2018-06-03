package com.main._13Exchanger;

import java.util.concurrent.Exchanger;

class FillAndEmpty {
   Exchanger<StringBuffer> exchanger = new Exchanger<StringBuffer>();
   String str = "what the hell , hello  world,avengers,american captain";
   StringBuffer initialEmptyBuffer = new StringBuffer();
   StringBuffer initialFullBuffer = new StringBuffer(str);

   class FillingLoop implements Runnable {
     public void run() {
         StringBuffer currentBuffer = initialEmptyBuffer;
         System.out.println(Thread.currentThread().getName()+" initialEmptyBuffer 的初始值"+currentBuffer);
       try {
           System.out.println(Thread.currentThread().getName()+"开始交换："+currentBuffer);
           currentBuffer = exchanger.exchange(currentBuffer);
           System.out.println(Thread.currentThread().getName()+"完成交换："+currentBuffer);
       } catch (InterruptedException ex) {  }
     }
   }

   class EmptyingLoop implements Runnable {
     public void run() {
       StringBuffer currentBuffer = initialFullBuffer;
         System.out.println(Thread.currentThread().getName()+" initialFullBuffer 的初始值"+currentBuffer);
       try {
           System.out.println(Thread.currentThread().getName()+"开始交换："+currentBuffer);
           currentBuffer = exchanger.exchange(currentBuffer);
           System.out.println(Thread.currentThread().getName()+"完成交换："+currentBuffer);
       } catch (InterruptedException ex) { }
     }
   }

    public static void main(String[] args) {
        FillAndEmpty fae = new FillAndEmpty();
        new Thread(fae.new FillingLoop() ).start();
        new Thread(fae.new EmptyingLoop()).start();
    }

 }