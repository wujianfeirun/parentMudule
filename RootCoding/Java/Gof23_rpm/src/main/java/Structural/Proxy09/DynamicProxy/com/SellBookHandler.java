package Structural.Proxy09.DynamicProxy.com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by asus on 2017/11/19.
 */
public class SellBookHandler implements InvocationHandler {
    private Subject realSubject;

    public SellBookHandler(Subject realSubject) {
        this.realSubject = realSubject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        discount();
        Object result = method.invoke(realSubject,args);
        bond();

        return result;
    }


    public void discount(){
        System.out.println("execute discount");
    }

    public void bond(){
        System.out.println("execute bond");
    }
}
