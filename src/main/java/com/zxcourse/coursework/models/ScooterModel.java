package com.zxcourse.coursework.models;

import com.zxcourse.coursework.entities.ClientEntity;
import com.zxcourse.coursework.entities.ScooterEntity;

public class ScooterModel {
    Long id;
    Integer chargePercent;
    String geolocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChargePercent() {
        return chargePercent;
    }

    public void setChargePercent(Integer chargePercent) {
        this.chargePercent = chargePercent;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public static ScooterModel toModel(ScooterEntity entity){
        ScooterModel model = new ScooterModel();
        model.setId(entity.getId());
        model.setGeolocation(entity.getGeolocation());
        model.setChargePercent(entity.getChargePercent());
        return model;
    }
}
