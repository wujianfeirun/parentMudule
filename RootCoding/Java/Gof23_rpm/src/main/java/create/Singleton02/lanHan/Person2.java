package create.Singleton02.lanHan;

/**
 * Created by asus on 2017/11/18.
 */
public class Person2 {

    private String name;

    private static Person2 person;

    private Person2() {
    }

    //TODO  use sysnc method to make sure single
    public synchronized static Person2 getPerson(){
        if(person == null) {
            person = new Person2();
        }
        return person;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
