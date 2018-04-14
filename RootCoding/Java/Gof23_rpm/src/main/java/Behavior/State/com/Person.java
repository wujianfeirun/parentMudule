package Behavior.State.com;

/**
 * Created by asus on 2017/11/26.
 */
public class Person {

    private int hour;
    private State state ;

    public Person() {
        this.state = new MState();
    }

    public void doSomething( ){
        state.doSomething(this);
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}
