package com.ood.waterball.teampathy.DomainModels.Domains;

import com.ood.waterball.teampathy.DomainModels.Entity;
import com.ood.waterball.teampathy.DomainModels.WBS.TaskItem;


public abstract class TaskEntity extends Entity implements TaskItem{
    protected String name;
    protected String ofGroupName;

    public TaskEntity(String name) {
        this.name = name;
    }
    public TaskEntity(int id,String name) {
        this.name = name;
        this.id = id;
    }
    public TaskEntity(int id,String name,String ofGroupName) {
        this.name = name;
        this.id = id;
        this.ofGroupName = ofGroupName;
    }

    public TaskEntity(String name,String ofGroupName) {
        this.name = name;
        this.ofGroupName = ofGroupName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getOfGroupName() {
        return ofGroupName;
    }

    @Override
    public void setOfGroupName(String ofGroupName) {
        this.ofGroupName = ofGroupName;
    }

}
