package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.Entity;

import java.util.Date;

public class TodoTask extends Entity {
    private String name;
    private String groupName;
    private String content;
    private Date startDate;
    private Date endDate;

    public TodoTask() {}

    public TodoTask(int id,String groupName, String name,String content) {
        this.id = id;
        this.groupName = groupName;
        this.name = name;
        this.content = content;
        startDate = new Date();
        endDate = new Date();
    }

    public TodoTask(String groupName, String name,String content) {
        this.groupName = groupName;
        this.name = name;
        this.content = content;
        startDate = new Date();
        endDate = new Date();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
