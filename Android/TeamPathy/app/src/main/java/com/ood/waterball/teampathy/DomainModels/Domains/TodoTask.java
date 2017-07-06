package com.ood.waterball.teampathy.DomainModels.Domains;


import com.ood.waterball.teampathy.DomainModels.WBS.TaskItem;
import com.ood.waterball.teampathy.DomainModels.WBS.WbsVisitor;

import org.w3c.dom.Node;

import java.util.Date;

public class TodoTask extends TaskEntity implements TaskItem {
    private String description;
    private Date startDate;
    private Date endDate;
    private int contributePoint;

    public TodoTask() {
        super("");
    }

    public TodoTask(int id, String ofGroupName, String name, String description) {
        super(id,name,ofGroupName);
        this.description = description;
        startDate = new Date();
        endDate = new Date();
    }

    public TodoTask(String ofGroupName, String name, String description) {
        super(name,ofGroupName);
        this.description = description;
        startDate = new Date();
        endDate = new Date();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getContributePoint() {
        return contributePoint;
    }

    public void setContributePoint(int contributePoint) {
        this.contributePoint = contributePoint;
    }

    @Override
    public Node toXmlNode() {
        //todo xml to node
        return null;
    }

    @Override
    public boolean hasChild() {
        return false;
    }

    @Override
    public void addChild(WbsVisitor visitor) {
        visitor.taskViewOnClick(this);
    }

    @Override
    public void edit(WbsVisitor visitor) {
        visitor.taskViewOnLongClick(this);
    }
}
