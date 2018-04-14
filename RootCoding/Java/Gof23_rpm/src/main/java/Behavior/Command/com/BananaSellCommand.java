package Behavior.Command.com;

/**
 * Created by asus on 2017/11/26.
 */
public class BananaSellCommand implements Command {
    private Boss boss=null;

    public BananaSellCommand(Boss boss) {
        this.boss = boss;
    }

    public void sell() {
        boss.sellBanana();
    }
}
