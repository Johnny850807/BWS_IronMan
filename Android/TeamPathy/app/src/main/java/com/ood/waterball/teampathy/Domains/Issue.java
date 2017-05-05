package com.ood.waterball.teampathy.Domains;


import com.ood.waterball.teampathy.Controllers.Global;

import java.util.Date;

public class Issue extends Entity {
    private String title;
    private String content;
    private String type;
    private Date postDate;
    private Member poster;

    public Issue(){}

    public Issue(Member poster,String title,String content,String type){
        this.poster = poster;
        this.title = title;
        this.content = content;
        this.type = type;
        postDate = new Date();
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Issue getClone()throws CloneNotSupportedException{
        return (Issue) this.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Issue(poster,title,content,type);
    }

    public String getDateString(){
        return Global.getTeamPathyFacade().convertDateToString(postDate);
    }
}
