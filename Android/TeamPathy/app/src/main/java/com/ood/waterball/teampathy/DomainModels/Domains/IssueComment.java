package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.PostDateEntity;

import java.util.Date;

public class IssueComment extends PostDateEntity {
    private User poster;
    private String content;

    public IssueComment(){
        super(new Date());
    }

    public IssueComment(User poster, String content, Date postDate){
        super(postDate);
        this.poster = poster;
        this.content = content;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
