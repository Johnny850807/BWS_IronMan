package com.ood.waterball.teampathy.DomainModels.Domains;

import com.ood.waterball.teampathy.DomainModels.Entity;


public class IssueType extends Entity {
    private String name;

    public IssueType() {}

    public IssueType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
