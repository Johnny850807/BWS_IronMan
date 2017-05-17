package com.ood.waterball.teampathy.DomainModels;


import java.io.Serializable;

public class Entity implements Cloneable , Serializable{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
