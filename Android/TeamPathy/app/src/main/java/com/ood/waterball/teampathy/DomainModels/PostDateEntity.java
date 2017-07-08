package com.ood.waterball.teampathy.DomainModels;


import com.ood.waterball.teampathy.Controllers.Global;

import java.util.Date;

public class PostDateEntity extends Entity {

    protected Date postDate;

    public PostDateEntity(Date date){
        this.postDate = date;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getDateString(){
        return Global.dateConvertStrategy.dateToTime(postDate,true);
    }
}
