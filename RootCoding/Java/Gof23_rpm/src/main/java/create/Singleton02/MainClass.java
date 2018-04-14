package create.Singleton02;

import create.Singleton02.ehan.Person;

/**
 * Created by asus on 2017/11/18.
 */
public class MainClass {
    public static void main(String[] args) {
        //e han
        Person per1  = Person.getPerson();
        Person per2  = Person.getPerson();
        per1.setName("zhangsan");
        per2.setName("lisi");
        System.out.println(per1.getName()  +"   "+per2.getName());


}

}
