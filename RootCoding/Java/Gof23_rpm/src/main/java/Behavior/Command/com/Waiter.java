package Behavior.Command.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/11/26.
 */
public class Waiter {
    private List<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void removeCommand(Command command){
        this.commands.remove(command);
    }

    public void sell(){
        for(Command command:commands){
            command.sell();
        }
    }

}
