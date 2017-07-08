package com.ood.waterball.teampathy.DomainModels.WBS;


import com.ood.waterball.teampathy.Controllers.Global;
import com.ood.waterball.teampathy.Controllers.MyUtils.DateConvertStrategy.DateConvertStrategy;
import com.ood.waterball.teampathy.DomainModels.Domains.TaskEntity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public TodoTask(String ofGroupName, String name, String description, int contributePoint) {
        this(ofGroupName,name,description);
        this.contributePoint = contributePoint;
    }

    @Override
    public List<TaskItem> toList() {
        List<TaskItem> taskItemList = new ArrayList<>();
        taskItemList.add(this);
        return taskItemList;
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
    public Node toXmlNode(Document document) {
        DateConvertStrategy strategy = Global.dateConvertStrategy;
        Element element = document.createElement(XmlTranslatorImp.TASK_NAME);
        element.setAttribute(XmlTranslatorImp.NAME_ATT,name);
        element.setAttribute(XmlTranslatorImp.DESCRIPTION_ATT,description);
        element.setAttribute(XmlTranslatorImp.STARTDATE_ATT,strategy.dateToTime(startDate,false));
        element.setAttribute(XmlTranslatorImp.ENTDATE_ATT,strategy.dateToTime(endDate,false));
        element.setAttribute(XmlTranslatorImp.CONTRIBUTION_ATT, String.valueOf(contributePoint));
        return element;
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

}
