package com.main._07ProducerConsumer;

public class TmallConsumer implements Runnable{

    private Tmall tmall;

    public TmallConsumer(Tmall tmall){
        this.tmall=tmall;
    }

    @Override
    public void run() {
        while(true){
            tmall.take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
