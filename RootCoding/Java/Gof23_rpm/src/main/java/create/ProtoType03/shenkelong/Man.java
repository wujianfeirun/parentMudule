package create.ProtoType03.shenkelong;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/11/18.
 */
public class Man implements Cloneable{
    private String name;
    private int age;

    //List is object， just copy the link。
    private List<String> friends;

    private Man father;

    public Man clone() {
        try {
            Man man = (Man) super.clone();

            //TODO add with traversal
            List<String> newFriends = new ArrayList<String>();
            for (String friend : this.getFriends()) {
                newFriends.add(friend);
            }
            man.setFriends(newFriends);

            //TODO add with clone.
            Man newFather = father.clone();
            man.setFather(newFather);

            return man;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }













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

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Man getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }
}
