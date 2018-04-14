package Behavior.Strategy06.com;

/**
 * Created by asus on 2017/11/19.
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double money){
        return this.strategy.cost(money);
    }

}
