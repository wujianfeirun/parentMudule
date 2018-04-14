package Behavior.Observer07.com;

import java.util.Observable;

/**
 * Created by asus on 2017/11/19.
 */
public class BlogMaster extends Observable {

    public void publishArticle(Article article){
        System.out.println("Blog Master published a Article : "+article.getAticleTitle());
        this.setChanged();      //change the changed flag to true to notify.
        this.notifyObservers(article);
    }

}
