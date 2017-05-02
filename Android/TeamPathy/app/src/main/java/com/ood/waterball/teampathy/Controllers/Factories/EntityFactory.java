package com.ood.waterball.teampathy.Controllers.Factories;


import com.ood.waterball.teampathy.Domains.Entity;

public interface EntityFactory {

    public Entity getEntityById(String id);
    public Entity getEntityListByKeyAndValue(String attributekey,String value);

}
