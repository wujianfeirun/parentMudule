package Structural.Proxy09.DynamicProxy;


import Structural.Proxy09.DynamicProxy.com.RealSubject;
import Structural.Proxy09.DynamicProxy.com.SellBookHandler;
import Structural.Proxy09.DynamicProxy.com.Subject;

import java.lang.reflect.Proxy;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();

        SellBookHandler myHandler = new SellBookHandler(realSubject);

        realSubject =(Subject)Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),myHandler);

        realSubject.sellBook();
    }


}
