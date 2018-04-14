package Behavior.State.com;

/**
 * Created by asus on 2017/11/26.
 */
public class BState implements State{


    public void doSomething(Person person){
        if(person.getHour() ==12){
            System.out.println("吃午餐");
        }else {
            person.setState(new NState());
            person.doSomething();
        }
    }
}
