package Behavior.Observer07.com;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by asus on 2017/11/19.
 */
public class ArticleConsumer1 implements Observer {
    public void update(Observable o, Object arg) {
        Article article = (Article)arg;
        System.out.println("consumer1 get the article: "+article.getAticleTitle());
    }
}
