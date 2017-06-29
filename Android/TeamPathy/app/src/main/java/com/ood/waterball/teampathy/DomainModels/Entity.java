package com.ood.waterball.teampathy.DomainModels;


import java.io.Serializable;

public class Entity implements Cloneable , Serializable{
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Entity && id == ((Entity) obj).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
