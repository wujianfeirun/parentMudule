package com.main._07ProducerConsumer;

public class TmallTest {

    public static void main(String[] args) {
        Tmall mall = new Tmall();
        TmallProducer p = new TmallProducer(mall);
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();

        TmallConsumer c = new TmallConsumer(mall);
        new Thread(c).start();
        new Thread(c).start();


    }
}
