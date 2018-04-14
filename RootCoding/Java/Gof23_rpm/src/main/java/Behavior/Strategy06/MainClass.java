package Behavior.Strategy06;

import Behavior.Strategy06.com.Context;
import Behavior.Strategy06.com.DiscountStrategy;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        Context context = new Context(new DiscountStrategy());
        double money = context.cost(200);
        System.out.println(money);

    }
}
