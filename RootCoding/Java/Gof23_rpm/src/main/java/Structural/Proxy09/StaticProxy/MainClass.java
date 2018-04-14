package Structural.Proxy09.StaticProxy;

import Structural.Proxy09.StaticProxy.com.ProxySubject;
import Structural.Proxy09.StaticProxy.com.RealSubject;
import Structural.Proxy09.StaticProxy.com.Subject;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        realSubject.sellBook();

        realSubject = new ProxySubject(realSubject);
        realSubject.sellBook();
    }


}
