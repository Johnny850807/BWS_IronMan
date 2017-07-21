package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.PostDateEntity;

import java.util.Date;

public class Timeline extends PostDateEntity {

    private User poster;
    private String content;
    private Date postdate;
    private int type;
    private int color;

    public Timeline(User poster, String content, Date postdate) {
        super(postdate);
        this.content = content;
        this.postdate = postdate;
        this.poster = poster;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return poster.getName() + ":" + content;
    }

}
