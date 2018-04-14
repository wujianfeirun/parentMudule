package create.Factory01.AbstractFactory3;

import create.Factory01.AbstractFactory3.com.Fruit;

/**
 * Created by asus on 2017/11/18.
 */
public class MainClass {
    public static void main(String[] args) {
        AbstractFactory af = new NorthFruitFactory();
        Fruit northApple = af.getApple();
        Fruit northBanana = af.getOrange();

        af = new SoutFruitFactory();
        Fruit southApple = af.getApple();
        Fruit southOrange = af.getOrange();
    }
}
