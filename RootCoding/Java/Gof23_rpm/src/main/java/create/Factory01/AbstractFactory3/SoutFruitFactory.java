package create.Factory01.AbstractFactory3;

import create.Factory01.AbstractFactory3.com.Fruit;
import create.Factory01.AbstractFactory3.com.SouthApple;
import create.Factory01.AbstractFactory3.com.SouthOrange;

/**
 * Created by asus on 2017/11/18.
 */
public class SoutFruitFactory implements AbstractFactory {
    public Fruit getApple() {
        return new SouthApple();
    }

    public Fruit getOrange() {
        return new SouthOrange();
    }
}
