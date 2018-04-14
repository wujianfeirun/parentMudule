package Behavior.Memento.com;

/**
 * Created by asus on 2017/11/26.
 */
public class Person {
    public String name;
    public String sex;
    public int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Memento createMemento(){
        return new Memento(name,sex,age);
    }

    public void recovery(Memento memento){
        this.name = memento.getName();
        this.sex = memento.getSex();
        this.age = memento.getAge();
    }

    @Override
    public String toString() {
        return "name:"+name+", sex:"+sex+", age:"+age;
    }
}
