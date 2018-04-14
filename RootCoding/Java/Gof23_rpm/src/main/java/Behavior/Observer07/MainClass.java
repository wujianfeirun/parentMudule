package Behavior.Observer07;

import Behavior.Observer07.com.Article;
import Behavior.Observer07.com.ArticleConsumer1;
import Behavior.Observer07.com.ArticleConsumer2;
import Behavior.Observer07.com.BlogMaster;

/**
 * Created by asus on 2017/11/19.
 */
public class MainClass {
    public static void main(String[] args) {
        Article article = new Article("fisrt design mode","observer design mode");
        BlogMaster b = new BlogMaster();
        b.addObserver(new ArticleConsumer1());
        b.addObserver(new ArticleConsumer2());
        b.addObserver(new ArticleConsumer2());

        b.publishArticle(article);
    }
}
