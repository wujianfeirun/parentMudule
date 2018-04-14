package Behavior.Command;

import Behavior.Command.com.*;

/**
 * Created by asus on 2017/11/26.
 */
public class MainClass {
    public static void main(String[] args) {
        Boss boss = new Boss();

        Command bananaCmd = new BananaSellCommand(boss);
        Command appleCmd = new AppleSellCommand(boss);
        Command pearCmd = new PearSellCommand(boss);

        Waiter waiter = new Waiter();
        waiter.addCommand(bananaCmd);
        waiter.addCommand(appleCmd);
        waiter.addCommand(pearCmd);
        waiter.addCommand(appleCmd);

        waiter.sell();
    }


}
