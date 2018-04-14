package create.Decorator05;

import create.Decorator05.com.Car;
import create.Decorator05.com.FlyCarDecorator;
import create.Decorator05.com.RunCar;
import create.Decorator05.com.SwimCarDecorator;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        Car car = new RunCar();
        car = new FlyCarDecorator(car);
        car = new SwimCarDecorator(car);
        car.show();
    }
}
