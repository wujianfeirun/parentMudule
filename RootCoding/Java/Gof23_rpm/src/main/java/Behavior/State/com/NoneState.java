package Behavior.State.com;

/**
 * Created by asus on 2017/11/26.
 */
public class NoneState implements State{
    Person person;


    public void doSomething(Person person){
        System.out.println(person.getHour()+"点，不吃饭");

        person.setState(new MState());
    }
}
