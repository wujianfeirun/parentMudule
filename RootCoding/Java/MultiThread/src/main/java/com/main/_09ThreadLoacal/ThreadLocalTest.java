package com.main._09ThreadLoacal;


/**
 * 统计get方法调用次数和set方法调用次数。
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> local1 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };
    private ThreadLocal<Integer> local2 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };


    public synchronized int getMethod(){
        Integer value = local1.get();
        local1.set(++value);
        return value;
    }

    public synchronized int setMethod(){
        Integer value = local2.get();
        local2.set(++value);
        return value;
    }


    public static void main(String[] args) {
        ThreadLocalTest tlt = new ThreadLocalTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" set "+ tlt.setMethod());
                    System.out.println(Thread.currentThread().getName()+" set "+ tlt.setMethod());
                    System.out.println(Thread.currentThread().getName()+" get "+ tlt.getMethod());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" get "+ tlt.getMethod());
                    System.out.println(Thread.currentThread().getName()+" set "+ tlt.setMethod());
                    System.out.println(Thread.currentThread().getName()+" set "+ tlt.setMethod());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

}
