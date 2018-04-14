package Behavior.TemplateMethod.com;

/**
 * Created by asus on 2017/11/26.
 */
public abstract class AbstractCar {
    public abstract void makeHead();
    public abstract void makeBody();
    public abstract void makeTail();

    public void make(){
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
