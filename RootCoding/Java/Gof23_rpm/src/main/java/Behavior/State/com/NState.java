package Behavior.State.com;

/**
 * Created by asus on 2017/11/26.
 */
public class NState implements State{


    public void doSomething(Person person){
        if(person.getHour() ==18){
            System.out.println("吃晚餐");
        }else{
            person.setState(new NoneState());
            person.doSomething();
        }
    }
}
