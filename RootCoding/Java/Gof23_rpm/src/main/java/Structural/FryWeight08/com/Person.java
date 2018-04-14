package Structural.FryWeight08.com;

/**
 * Created by asus on 2017/11/19.
 */
public abstract class Person {
    private String name;
    private int age;

    public void display(){};


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
