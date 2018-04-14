package Behavior.Command.com;

/**
 * Created by asus on 2017/11/26.
 */
public class AppleSellCommand implements Command {
    private Boss boss=null;

    public AppleSellCommand(Boss boss) {
        this.boss = boss;
    }

    public void sell() {
        boss.sellPear();
    }
}
