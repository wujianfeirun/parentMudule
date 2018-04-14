package create.Factory01.FactoryMethod2;

import create.Factory01.FactoryMethod2.com.Fruit;
import create.Factory01.FactoryMethod2.com.Orange;

/**
 * Created by asus on 2017/11/18.
 */
public class OrangeFactory implements FactoryMethod{
    public Fruit getFruit() {
        return new Orange();
    }
}
