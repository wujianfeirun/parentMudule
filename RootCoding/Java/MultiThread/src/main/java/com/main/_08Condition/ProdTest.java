package com.main._08Condition;

public class ProdTest {

    public static void main(String[] args) {
         ComplexProd cp = new ComplexProd();
         new Thread(new ProdAProduce(cp)).start();
         new Thread(new ProdAProduce(cp)).start();
         new Thread(new ProdAProduce(cp)).start();
         new Thread(new ProdBProduce(cp)).start();
         new Thread(new ProdBProduce(cp)).start();
         new Thread(new ProdBProduce(cp)).start();
         new Thread(new ProdCProduce(cp)).start();
         new Thread(new ProdCProduce(cp)).start();
         new Thread(new ProdCProduce(cp)).start();
    }
}
