package Behavior.Mediator.com;

/**
 * Created by asus on 2017/11/23.
 */
public class Woman implements Person {
    private String name;
    private int condition;
    private Mediator mediator;


    public Woman(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public void getPartner() {
        mediator.getPartner(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        mediator.add(this);
    }
}
