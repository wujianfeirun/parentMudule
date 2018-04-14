package Behavior.Strategy06.com;

/**
 * Created by asus on 2017/11/19.
 */
public class MinusStrategy implements Strategy {
    public double cost(double money) {
        if(money>=200){
            return money-50;
        }
        return money;
    }
}
