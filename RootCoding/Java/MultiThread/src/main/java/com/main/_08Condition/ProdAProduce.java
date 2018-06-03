package com.main._08Condition;

public class ProdAProduce implements Runnable {
    private ComplexProd prod;

    public ProdAProduce(ComplexProd prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        while(true){
            prod.a();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
