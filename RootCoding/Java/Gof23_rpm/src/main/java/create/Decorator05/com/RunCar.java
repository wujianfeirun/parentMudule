package create.Decorator05.com;

/**
 * Created by asus on 2017/11/19.
 */
public class RunCar implements Car{

    public void run() {
        System.out.println("can run");
    }

    public void show() {
        this.run();
    }
}
