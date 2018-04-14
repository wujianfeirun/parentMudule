package Behavior.TemplateMethod.com;

/**
 * Created by asus on 2017/11/26.
 */
public class Bus extends AbstractCar{
    public void makeHead() {
        System.out.println("Bus: make Head");
    }

    public void makeBody() {
        System.out.println("Bus: make Body");
    }

    public void makeTail() {
        System.out.println("Bus: make Tail");
    }
}
