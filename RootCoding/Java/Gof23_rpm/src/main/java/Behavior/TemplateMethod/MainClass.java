package Behavior.TemplateMethod;

import Behavior.TemplateMethod.com.AbstractCar;
import Behavior.TemplateMethod.com.Bus;

/**
 * Created by asus on 2017/11/26.
 */
public class MainClass {
    public static void main(String[] args) {
        AbstractCar bus = new Bus();
        bus.make();
    }
}
