package create.Decorator05.com;

/**
 * Created by asus on 2017/11/19.
 */
public abstract class CarDecorator implements Car{
    Car car = null;
    public CarDecorator(Car car) {
        this.car = car;
    }


}
