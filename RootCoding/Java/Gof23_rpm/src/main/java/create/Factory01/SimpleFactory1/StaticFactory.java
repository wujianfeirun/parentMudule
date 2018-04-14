package create.Factory01.SimpleFactory1;

import create.Factory01.SimpleFactory1.com.Child1;
import create.Factory01.SimpleFactory1.com.Child2;
import create.Factory01.SimpleFactory1.com.Parent;

/**
 * Created by asus on 2017/11/18.
 */
public class StaticFactory {

    //TODO first version
    public static Parent getChild1(){
        return new Child1();
    }
    public static Parent getChild2(){
        return new Child2();
    }

    //TODO second version
    public static Parent getChilds(String str){
        if(str.equals("child1")){
            return getChild1();
        }else if(str.equals("child2")){
            return getChild2();
        }else{
            return null;
        }
    }

    //TODO final version
    public static Parent getChildByClass(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Parent) Class.forName(str).newInstance();
    }

}
