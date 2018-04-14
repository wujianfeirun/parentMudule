package create.Factory01.AbstractFactory3;

import create.Factory01.AbstractFactory3.com.Fruit;
import create.Factory01.AbstractFactory3.com.NorthApple;
import create.Factory01.AbstractFactory3.com.NorthOrange;

/**
 * Created by asus on 2017/11/18.
 */
public class NorthFruitFactory implements AbstractFactory {
    public Fruit getApple() {
        return new NorthApple();
    }

    public Fruit getOrange() {
        return new NorthOrange();
    }
}
