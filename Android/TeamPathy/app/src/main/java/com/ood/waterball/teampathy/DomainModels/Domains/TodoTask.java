package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.Entity;

import java.util.Date;

public class TodoTask extends Entity implements TaskItem{
    private String name;
    private String ofGroupName;
    private String content;
    private Date startDate;
    private Date endDate;
    private int contributePoint;

    public TodoTask() {}

    public TodoTask(int id, String ofGroupName, String name, String content) {
        this.id = id;
        this.ofGroupName = ofGroupName;
        this.name = name;
        this.content = content;
        startDate = new Date();
        endDate = new Date();
    }

    public TodoTask(String ofGroupName, String name, String content) {
        this.ofGroupName = ofGroupName;
        this.name = name;
        this.content = content;
        startDate = new Date();
        endDate = new Date();
    }

    public String getOfGroupName() {
        return ofGroupName;
    }

    public void setOfGroupName(String ofGroupName) {
        this.ofGroupName = ofGroupName;
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

    public int getContributePoint() {
        return contributePoint;
    }

    public void setContributePoint(int contributePoint) {
        this.contributePoint = contributePoint;
    }

    @Override
    public boolean hasChild() {
        return false;
    }
}
