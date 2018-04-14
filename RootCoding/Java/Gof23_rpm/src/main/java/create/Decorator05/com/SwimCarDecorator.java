package create.Decorator05.com;

/**
 * Created by asus on 2017/11/19.
 */
public class SwimCarDecorator extends CarDecorator{

    public SwimCarDecorator(Car car) {
        super(car);
    }

    public void run() {

    }

    public void show() {
        this.car.show();
        this.swim();
    }

    public void swim(){
        System.out.println("can swim");
    }

}

