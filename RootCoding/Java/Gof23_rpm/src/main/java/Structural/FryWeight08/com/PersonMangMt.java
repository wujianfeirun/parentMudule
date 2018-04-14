package Structural.FryWeight08.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2017/11/19.
 */
public class PersonMangMt {
    private Map<String,Person> pool;

    public PersonMangMt() {
        this.pool = new HashMap<String,Person>();
    }

    public Person getPerson(String name, int age){
        Person p = pool.get(name);
        if(p == null ){
            Teacher t = new Teacher();
            t.setAge(age);
            t.setName(name);

            pool.put(name,t);
            return t;
        }else{
            return p;
        }

    }
}
