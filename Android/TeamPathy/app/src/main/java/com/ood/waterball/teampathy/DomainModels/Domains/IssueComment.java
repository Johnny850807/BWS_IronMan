package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.PostDateEntity;

import java.util.Date;

public class IssueComment extends PostDateEntity {
    private Member poster;
    private String content;

    public IssueComment(){
        super(new Date());
    }

    public IssueComment(Member poster,String content,Date postDate){
        super(postDate);
        this.poster = poster;
        this.content = content;
    }

    public Member getPoster() {
        return poster;
    }

    public void setPoster(Member poster) {
        this.poster = poster;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
