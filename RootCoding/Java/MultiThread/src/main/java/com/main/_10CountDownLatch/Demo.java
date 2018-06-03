package com.main._10CountDownLatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class Demo {

    public static void main(String[] args) throws InterruptedException {
        List<String> results = readFile();
        final Integer[] sums = new Integer[results.size()];
        CountDownLatch latch = new CountDownLatch(results.size());

        for (int i = 0; i < results.size(); i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String [] strs = results.get(j).split(",");
                    int sum=0;
                    for (int i1 = 0; i1 < strs.length; i1++) {
                        sum +=Integer.parseInt(strs[i1]);
                    }
                    sums[j] = sum;
                    System.out.println(Thread.currentThread().getName()+" 计算第"+j+"行结果为 "+sum);
                    latch.countDown();              //在每一个线程执行完成之后调用countDown
                }
            }).start();

        }

        latch.await();                             //在汇总处等待
        int sum=0;
        for (int i = 0; i < sums.length; i++) {
            sum += sums[i];
        }
        System.out.println("计算总结果为 "+sum);

    }


    public static List<String> readFile(){
        List<String> result = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\WorkSpace\\Intellij\\winter-Java\\RootCoding\\Java\\MultiThread\\src\\main\\java\\com\\main\\_10CountDownLatch\\nums.txt"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.add(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
