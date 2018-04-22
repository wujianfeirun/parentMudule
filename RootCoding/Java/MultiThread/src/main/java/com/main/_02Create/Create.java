package com.main._02Create;

/**
 *   执行的是sub， 子类的方法；  而不是父类构造函数中传入的。
 */

public class Create {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("sub");
            }
        }.start();

    }

}
