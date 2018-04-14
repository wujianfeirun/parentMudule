package Behavior.State.com;

/**
 * Created by asus on 2017/11/26.
 */
public class MState implements State {

    public void doSomething(Person person) {
        if (person.getHour() == 7) {
            System.out.println("吃早餐");
        } else {
            person.setState(new BState());
            person.doSomething();
        }
    }
}
