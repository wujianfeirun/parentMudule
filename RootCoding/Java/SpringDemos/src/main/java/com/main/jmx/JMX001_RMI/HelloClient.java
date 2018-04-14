package com.main.jmx.JMX001_RMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class HelloClient {
    public static void main(String arg[]) {
        String message = "blank";

        // I download server's stubs ==> must set a SecurityManager 
        System.setSecurityManager(new RMISecurityManager());

        try {
            Hello obj = (Hello) Naming.lookup("//" +
                    "lysander.cs.ucsb.edu" +
                    "/HelloServer");         //objectname in registry
            System.out.println(obj.sayHello());
        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 