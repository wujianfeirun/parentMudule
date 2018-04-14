package create.Decorator05.com;

/**
 * Created by asus on 2017/11/19.
 */
public class FlyCarDecorator extends CarDecorator {

    public FlyCarDecorator(Car car) {
        super(car);
    }

    public void run() {

    }

    public void show() {
        this.car.show();
        this.fly();
    }

    public void fly(){
        System.out.println("can fly");
    }

}

