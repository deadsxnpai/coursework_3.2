package com.zxcourse.coursework.models;

import com.zxcourse.coursework.entities.ClientEntity;
import com.zxcourse.coursework.entities.RentEntity;

public class RentModel {
    Long id;
    Long client_id;
    String timeOnTrip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClient_id(ClientEntity client_id) {
        return this.client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getTimeOfTrip(String timeOnTrip) {
        return this.timeOnTrip;
    }

    public void setTimeOfTrip(String timeOnTrip) {
        this.timeOnTrip = timeOnTrip;
    }

    public static RentModel toModel(RentEntity entity){
        RentModel model = new RentModel();
        model.setId(entity.getId());
        model.getClient_id(entity.getClient_id());
        model.getTimeOfTrip(entity.getTimeOnTrip());
        return model;
    }
}
