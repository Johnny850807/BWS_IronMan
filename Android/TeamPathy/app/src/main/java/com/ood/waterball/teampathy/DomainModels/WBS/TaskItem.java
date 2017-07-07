package com.ood.waterball.teampathy.DomainModels.WBS;


import org.w3c.dom.Node;

import java.util.Date;
import java.util.List;

public interface TaskItem extends Iterable<TaskItem>{

    public List<TaskItem> toList();

    public void addTaskChild(TaskItem taskItem);

    public void setDegree(int degree);

    public int getDegree();

    public String getOfGroupName();

    public void setOfGroupName(String ofGroupName);

    public String getName();

    public void setName(String name);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public String getDescription();

    public void setDescription(String description);

    public int getContributePoint();

    public void setContributePoint(int contributePoint);

    public abstract Node toXmlNode();

    public abstract boolean hasChild();

    public abstract void onClick(WbsVisitor visitor);

    public abstract void onLongClick(WbsVisitor visitor);

}
