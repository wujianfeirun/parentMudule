package com.main._07ProducerConsumer;

public class TmallProducer implements Runnable{

    private Tmall tmall;

    public TmallProducer(Tmall tmall){
        this.tmall=tmall;
    }

    @Override
    public void run() {
        while (true){
            tmall.push();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
