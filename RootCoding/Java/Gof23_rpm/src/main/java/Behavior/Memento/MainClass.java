package Behavior.Memento;

import Behavior.Memento.com.CareTaker;
import Behavior.Memento.com.Person;

/**
 * Created by asus on 2017/11/26.
 */
public class MainClass {
    public static void main(String[] args) {
        Person person = new Person("winter","man",29);
        System.out.println(person.toString());

        CareTaker mgmt = new CareTaker(person.createMemento());

        person.setName("xxx");
        System.out.println(person.toString());

        person.recovery(mgmt.getMemento());
        System.out.println(person.toString());
    }
}
