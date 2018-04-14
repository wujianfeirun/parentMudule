package Structural.FryWeight08;

import Structural.FryWeight08.com.Person;
import Structural.FryWeight08.com.PersonMangMt;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        PersonMangMt pm = new PersonMangMt();

        Person p1 = pm.getPerson("xuxu", 20);
        Person p2 = pm.getPerson("xxx", 21);
        Person p3 = pm.getPerson("xuxu", 20);
        Person p4 = pm.getPerson("yyy", 20);
        Person p5 = pm.getPerson("xxx", 20);

        System.out.println(p1==p3);   //return true. Object share the cache.

    }
}
