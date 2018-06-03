package com.main._08Condition;

public class ProdBProduce implements Runnable {
    private ComplexProd prod;

    public ProdBProduce(ComplexProd prod) {
        this.prod = prod;
    }

    @Override
    public void run() {
        while(true){
            prod.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
