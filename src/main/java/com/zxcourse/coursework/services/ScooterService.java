package com.zxcourse.coursework.services;

import com.zxcourse.coursework.entities.ScooterEntity;
import com.zxcourse.coursework.exceptions.ScooterAlreadyExist;
import com.zxcourse.coursework.exceptions.ScooterNotFoundException;
import com.zxcourse.coursework.models.ScooterModel;
import com.zxcourse.coursework.repos.RentRepo;
import com.zxcourse.coursework.repos.ScooterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScooterService {
    @Autowired
    private ScooterRepo scooterRepo;
    @Autowired
    private RentRepo rentRepo;

    public ScooterEntity createScooter(ScooterEntity scooterEntity) throws ScooterAlreadyExist {
        return scooterRepo.save(scooterEntity);
    }

    public long deleteScooter(long id){
        scooterRepo.deleteById(id);
        return id;
    }

    public ScooterModel getOne(long id) throws ScooterNotFoundException {
        ScooterEntity scooterEntity = scooterRepo.findById(id).get() ;
        if(scooterEntity == null){
            throw new ScooterNotFoundException("Cant find scooter");
        }
        return ScooterModel.toModel(scooterEntity);
    }
}
