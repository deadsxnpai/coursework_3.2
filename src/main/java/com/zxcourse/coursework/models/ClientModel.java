package com.zxcourse.coursework.models;

import com.zxcourse.coursework.entities.ClientEntity;

public class ClientModel {
    Long id;
    String login;
    String email;

    public static ClientModel toModel(ClientEntity entity){
        ClientModel model = new ClientModel();
        model.setId(entity.getId());
        model.setLogin(entity.getLogin());
        model.setEmail(entity.getEmail());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
