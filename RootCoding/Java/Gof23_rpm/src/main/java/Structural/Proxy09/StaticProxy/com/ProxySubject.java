package Structural.Proxy09.StaticProxy.com;

/**
 * Created by asus on 2017/11/19.
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void sellBook() {
        discount();
        subject.sellBook();
        bond();
    }

    public void discount(){
        System.out.println("execute discount");
    }

    public void bond(){
        System.out.println("execute bond");
    }
}
