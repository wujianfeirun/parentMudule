package com.main._08Condition;

public class ProdCProduce implements Runnable {
    private ComplexProd prod;

    public ProdCProduce(ComplexProd prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        while(true){
            prod.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
