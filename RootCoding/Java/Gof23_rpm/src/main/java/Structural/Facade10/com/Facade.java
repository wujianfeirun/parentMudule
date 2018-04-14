package Structural.Facade10.com;

/**
 * Created by asus on 2017/11/20.
 */
public class Facade {
    SystemA systemA ;
    SystemB systemB ;
    SystemC systemC ;

    public Facade(){
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();
    }

    public void doA(){
        systemA.doSomething();
    }

    public void doAB(){
        systemA.doSomething();
        systemB.doSomething();
    }
    public void doABC(){
        systemA.doSomething();
        systemB.doSomething();
        systemC.doSomething();
    }

}
