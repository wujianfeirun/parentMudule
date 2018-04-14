package Behavior.Command.com;

/**
 * Created by asus on 2017/11/26.
 */
public class PearSellCommand implements Command {
    private Boss boss=null;

    public PearSellCommand(Boss boss) {
        this.boss = boss;
    }

    public void sell() {
        boss.sellApple();
    }
}
