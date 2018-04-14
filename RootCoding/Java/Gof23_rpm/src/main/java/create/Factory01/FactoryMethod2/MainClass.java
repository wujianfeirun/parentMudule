package create.Factory01.FactoryMethod2;

import create.Factory01.FactoryMethod2.add.BananaFactory;
import create.Factory01.FactoryMethod2.com.Fruit;

/**
 * Created by asus on 2017/11/18.
 */
public class MainClass {
    public static void main(String[] args) throws Exception {
        FactoryMethod fm = new AppleFactory();
        Fruit apple = fm.getFruit();

        fm = new OrangeFactory();
        Fruit orange = fm.getFruit();

        fm = new BananaFactory();
        Fruit banana = fm.getFruit();

    }
}
