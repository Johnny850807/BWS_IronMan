package com.ood.waterball.teampathy.Domains;


import java.util.Date;

public class IssueComment extends Entity{
    private Member poster;
    private String content;
    private Date postDate;

    public IssueComment(){}

    public IssueComment(Member poster,String content,Date postDate){
        this.postDate = postDate;
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
