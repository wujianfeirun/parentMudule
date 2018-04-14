package Behavior.Strategy06.com;

/**
 * Created by asus on 2017/11/19.
 */
public class DiscountStrategy implements Strategy {
    public double cost(double money) {
        return money*0.8;
    }
}
