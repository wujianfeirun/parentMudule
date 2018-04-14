package Behavior.Mediator.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/11/23.
 */
public class Mediator {
    List<Man> men = new ArrayList<Man>();
    List<Woman> women = new ArrayList<Woman>();

    public void add(Person person){
        if(person instanceof Man){
            men.add((Man) person);
        }else{
            women.add((Woman) person);
        }
    }

    public void getPartner(Person person) {
        if(person instanceof  Man){
            for(Woman woman:women){
                if(woman.getCondition()==((Man) person).getCondition()){
                    System.out.println("man "+((Man) person).getName() +"match "+woman.getName());
                }
            }
        }else{
            for(Man man:men){
                if(man.getCondition()==((Woman) person).getCondition()){
                    System.out.println("woman "+((Woman) person).getName() +"match "+man.getName());
                }
            }
        }
    }
}
