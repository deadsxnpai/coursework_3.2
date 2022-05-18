package com.zxcourse.coursework.exceptions;

import com.zxcourse.coursework.entities.ScooterEntity;

public class ScooterAlreadyExist extends Exception{
    public ScooterAlreadyExist(String message){
        super(message);
    }
}
