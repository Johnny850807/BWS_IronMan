package com.ood.waterball.teampathy.Domains;


import java.io.Serializable;

public class Entity implements Cloneable , Serializable{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
