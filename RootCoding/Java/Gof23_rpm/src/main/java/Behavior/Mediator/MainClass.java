package Behavior.Mediator;

import Behavior.Mediator.com.Man;
import Behavior.Mediator.com.Mediator;
import Behavior.Mediator.com.Woman;

/**
 * Created by asus on 2017/11/23.
 */
public class MainClass {

    public static void main(String[] args) {
        Man man1 = new Man("zhangsan",3);
        Man man2 = new Man("lisi",4);
        Man man3 = new Man("wangmazi",5);
        Man man4= new Man("maliu",6);
        Man man5 = new Man("tangqi",7);

        Woman woman1 = new Woman("liu3",3);
        Woman woman2 = new Woman("qiansi",4);
        Woman woman3= new Woman("zhao5",5);
        Woman woman4 = new Woman("sun6",6);
        Woman woman5 = new Woman("qiu7",7);

        Mediator mediator = new Mediator();

        man1.setMediator(mediator);
        man2.setMediator(mediator);
        man3.setMediator(mediator);
        man4.setMediator(mediator);
        man5.setMediator(mediator);

        woman1.setMediator(mediator);
        woman2.setMediator(mediator);
        woman3.setMediator(mediator);
        woman4.setMediator(mediator);
        woman5.setMediator(mediator);

        man1.getPartner();
        man2.getPartner();
        man3.getPartner();
        man4.getPartner();
        man5.getPartner();

    }
}
