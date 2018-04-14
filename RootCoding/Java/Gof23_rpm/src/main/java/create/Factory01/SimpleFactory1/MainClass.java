package create.Factory01.SimpleFactory1;

import create.Factory01.SimpleFactory1.com.Parent;

/**
 * Created by asus on 2017/11/18.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        Parent p = StaticFactory.getChild1();


        Parent p1 = StaticFactory.getChilds("child1");


        Parent p2 = StaticFactory.getChildByClass("Child1");
    }
}
