package com.ood.waterball.teampathy.DomainModels.Domains;


import java.util.Date;

public interface TaskItem {
    //todo composition pattern which needed by TaskItem and TaskGroup

    public String getOfGroupName();

    public void setOfGroupName(String ofGroupName);

    public String getName();

    public void setName(String name);

    public Date getEndDate();

    public void setEndDate(Date endDate);

    public Date getStartDate();

    public void setStartDate(Date startDate);

    public String getContent();

    public void setContent(String content);

    public int getContributePoint();

    public void setContributePoint(int contributePoint);

    public boolean hasChild();
}
