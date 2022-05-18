package com.zxcourse.coursework.services;

import com.zxcourse.coursework.entities.RentEntity;
import com.zxcourse.coursework.exceptions.RentAlreadyExist;
import com.zxcourse.coursework.exceptions.RentNotFoundException;
import com.zxcourse.coursework.models.RentModel;
import com.zxcourse.coursework.repos.RentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {
    @Autowired
    private RentRepo rentRepo;

    public RentEntity createRent(RentEntity rentEntity) throws RentAlreadyExist {
        if(rentRepo.findById(rentEntity.getId()) != null){
            throw new RentAlreadyExist("Rent already exist");
        }
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
