package com.ood.waterball.teampathy.DomainModels.WBS;


import com.ood.waterball.teampathy.DomainModels.Domains.TaskEntity;

import org.w3c.dom.Node;

import java.util.Date;
import java.util.Iterator;

public class TodoTask extends TaskEntity implements TaskItem {
    private String description;
    private Date startDate;
    private Date endDate;
    private int contributePoint;

    public TodoTask() {
        super("");
    }

    public TodoTask(int id, String ofGroupName, String name, String description) {
        super(id,ofGroupName,name);
        this.description = description;
        startDate = new Date();
        endDate = new Date();
    }

    public TodoTask(String ofGroupName, String name, String description) {
        super(ofGroupName,name);
        this.description = description;
        startDate = new Date();
        endDate = new Date();
    }

    @Override
    public void addTaskChild(TaskItem taskItem) {
        throw new RuntimeException("Not Supported.");
    }

    @Override
    public void setDegree(int degree) {
        this.degree = degree;
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
    public void onClick(WbsVisitor visitor) {
        visitor.taskViewOnClick(this);
    }

    @Override
    public void onLongClick(WbsVisitor visitor) {
        visitor.taskViewOnLongClick(this);
    }

    @Override
    public Iterator<TaskItem> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements java.util.Iterator<TaskItem>{
        boolean available = true;
        @Override
        public boolean hasNext() {
            return available;
        }

        @Override
        public TaskItem next() {
            available = false;
            return TodoTask.this;
        }
    }
}
