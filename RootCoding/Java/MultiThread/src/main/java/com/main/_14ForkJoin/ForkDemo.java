package com.main._14ForkJoin;

import java.util.concurrent.*;

public class ForkDemo extends RecursiveTask<Integer> {

    int begin;
    int end;

    public ForkDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-begin<=2){
            for(int i=begin;i<=end;i++){
                sum +=i;
            }
        }else{
            ForkDemo d1 = new ForkDemo(begin,(end-begin)/2);
            ForkDemo d2 = new ForkDemo((end-begin)/2 +1,end);

            d1.fork();
            d2.fork();
            int a = d1.join();
            int b = d2.join();
            sum = a+b;
        }

        return sum;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Future<Integer> future = new ForkJoinPool().submit(new ForkDemo(1,10));
        System.out.println(future.get());
    }
}
