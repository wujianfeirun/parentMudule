package com.main._03SpringThreads;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SpringService {

    @Async
    public void a() throws InterruptedException {
        while(true){
            System.out.println("a");
            Thread.sleep(1000);
        }
    }

    @Async
    public void b() throws InterruptedException {
        while(true){
            System.out.println("b");
            Thread.sleep(2000);
        }
    }
}


