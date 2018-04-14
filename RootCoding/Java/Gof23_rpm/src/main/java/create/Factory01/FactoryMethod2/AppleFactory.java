package create.Factory01.FactoryMethod2;

import create.Factory01.FactoryMethod2.com.Apple;
import create.Factory01.FactoryMethod2.com.Fruit;

/**
 * Created by asus on 2017/11/18.
 */
public class AppleFactory implements FactoryMethod {
    public Fruit getFruit() {
        return new Apple();
    }
}
