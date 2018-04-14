package create.Singleton02.shuangchong;

/**
 * Created by asus on 2017/11/18.
 */
public class Person3 {

    private String name;

    private static Person3 person;

    private Person3() {
    }

    //TODO  smaller the sync scale。
    public static Person3 getPerson(){
        if(person == null) {
            //just run once, so it can improve efficient.
            synchronized (Person3.class){
                if(person == null) {
                    person = new Person3();
                }
            }
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
