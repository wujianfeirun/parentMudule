package com.main._03SpringThreads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext acpc = new AnnotationConfigApplicationContext(Config.class);

        SpringService ss = acpc.getBean(SpringService.class);

        ss.a();

        ss.b();

    }

}
