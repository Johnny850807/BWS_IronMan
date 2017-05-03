package com.ood.waterball.teampathy.Domains;





public class Issue extends Entity {
    private String title;
    private String content;
    private Member poster;

    public Issue(){}

    public Issue(Member poster,String title,String content){
        this.poster = poster;
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Member getPoster() {
        return poster;
    }

    public void setPoster(Member poster) {
        this.poster = poster;
    }
}
