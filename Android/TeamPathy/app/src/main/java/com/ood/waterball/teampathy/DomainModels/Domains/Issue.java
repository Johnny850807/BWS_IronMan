package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.PostDateEntity;

import java.util.Date;

public class Issue extends PostDateEntity {
    private String title;
    private String content;
    private IssueType type;
    private Date postDate;
    private User poster;

    public Issue(){
        super(new Date());
    }

    public Issue(User poster, String title, String content, IssueType type){
        super(new Date());
        this.poster = poster;
        this.title = title;
        this.content = content;
        this.type = type;
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

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public Issue getClone()throws CloneNotSupportedException{
        return (Issue) this.clone();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Issue(poster,title,content,type);
    }


}
