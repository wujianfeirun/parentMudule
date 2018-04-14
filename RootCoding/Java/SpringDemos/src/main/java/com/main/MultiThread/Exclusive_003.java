package com.main.MultiThread;/*
package com.main.MultiThread;

*/
/**
 * Created by asus on 2017/3/16.
 * 对资源的独占与共享
 * 内部类能直接访问外部类的的成员变量，所以外部类的静态方法不能实例内部类
 *//*

public class Exclusive_003 {

    public static void main(String[] args) throws InterruptedException {
        new Exclusive_003().init();

    }
    public void init(){
        Outputer outputer= new Outputer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    outputer.output("liuyangheyyfefefa");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    outputer.output("shanghaidaxuechgn");
                }

            }
        }).start();


    }


}

class Outputer {
     public  void output(String name){
         int len = name.length();
         //桩相当于一把锁，必须是同一个对象才能达到互斥的效果，name达不到互斥的效果
*/
/*         synchronized (name) {
             for (int i = 0; i < len; i++) {
                 System.out.println(name.charAt(i));
             }
         }*//*

         synchronized (this) {
             for (int i = 0; i < len; i++) {
                 System.out.print(name.charAt(i));
             }
             System.out.println();
         }
     }

    public  void output1(String name){
        int len = name.length();
        synchronized (" ") {
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

    public  void output2(String name){
        int len = name.length();
        synchronized (Outputer.class) {
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
     //同步方法，使用的桩也是this对象,所以output和sync_output可以互斥
     public synchronized void sync_output(String name){
         int len = name.length();
         for (int i = 0; i < len; i++) {
             System.out.print(name.charAt(i));
         }
         System.out.println();
     }

     //使用的桩是Class,  output2和sta_sync_output是互斥
     public synchronized static void sta_sync_output(String name){
         int len = name.length();
         for (int i = 0; i < len; i++) {
             System.out.print(name.charAt(i));
         }
         System.out.println();
     }
}
*/
