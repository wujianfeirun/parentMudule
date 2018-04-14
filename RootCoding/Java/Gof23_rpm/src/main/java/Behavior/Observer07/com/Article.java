package Behavior.Observer07.com;

/**
 * Created by asus on 2017/11/19.
 */
public class Article {
    public String aticleTitle;
    public String aticleContent;

    public Article(String aticleTitle, String aticleContent) {
        this.aticleTitle = aticleTitle;
        this.aticleContent = aticleContent;
    }

    public String getAticleTitle() {
        return aticleTitle;
    }

    public void setAticleTitle(String aticleTitle) {
        this.aticleTitle = aticleTitle;
    }

    public String getAticleContent() {
        return aticleContent;
    }

    public void setAticleContent(String aticleContent) {
        this.aticleContent = aticleContent;
    }
}
