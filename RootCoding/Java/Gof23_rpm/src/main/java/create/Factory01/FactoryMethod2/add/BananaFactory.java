package create.Factory01.FactoryMethod2.add;

import create.Factory01.FactoryMethod2.FactoryMethod;
import create.Factory01.FactoryMethod2.com.Fruit;

/**
 * Created by asus on 2017/11/18.
 */
public class BananaFactory implements FactoryMethod {
    public Fruit getFruit() {
        return new Banana();
    }
}
