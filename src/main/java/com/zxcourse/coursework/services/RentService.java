package com.zxcourse.coursework.services;

import com.zxcourse.coursework.entities.ClientEntity;
import com.zxcourse.coursework.entities.RentEntity;
import com.zxcourse.coursework.entities.ScooterEntity;
import com.zxcourse.coursework.exceptions.RentAlreadyExist;
import com.zxcourse.coursework.exceptions.RentNotFoundException;
import com.zxcourse.coursework.models.RentModel;
import com.zxcourse.coursework.repos.ClientRepo;
import com.zxcourse.coursework.repos.RentRepo;
import com.zxcourse.coursework.repos.ScooterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    @Autowired
    private RentRepo rentRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private ScooterRepo scooterRepo;
    public RentEntity createRent(RentEntity rentEntity, Long userId, Long scooterId) throws RentAlreadyExist {
        ClientEntity clientEntity = clientRepo.findById(userId).get();
        ScooterEntity scooterEntity = scooterRepo.findById(scooterId).get();
        rentEntity.setClient_id(clientEntity);
        rentEntity.setScooter_id(scooterEntity);
        return rentRepo.save(rentEntity);
    }

    public long deleteRent(long id){
        rentRepo.deleteById(id);
        return id;
    }

    public RentModel getOne(long id) throws RentNotFoundException {
        RentEntity rentEntity = rentRepo.findById(id).get() ;
        if(rentEntity == null){
            throw new RentNotFoundException("Rent not found");
        }
        return RentModel.toModel(rentEntity);
    }

}
