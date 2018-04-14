package Behavior.Memento.com;

/**
 * Created by asus on 2017/11/26.
 */
public class CareTaker {
    private Memento memento;

    public CareTaker(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
