package create.Singleton02.ehan;

/**
 * Created by asus on 2017/11/18.
 */
public class Person {
    private String name;

    private static final Person person = new Person();

    private Person() {
        this.name = name;
    }

    public static Person getPerson(){
        return person;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
