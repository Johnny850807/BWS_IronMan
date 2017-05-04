package com.ood.waterball.teampathy.Domains;


import java.util.Date;

public class Issue extends Entity {
    private String title;
    private String content;
    private String type;
    private Date datetime;
    private Member poster;

    public Issue(){}

    public Issue(Member poster,String title,String content,String type){
        this.poster = poster;
        this.title = title;
        this.content = content;
        this.type = type;
        datetime = new Date();
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

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
