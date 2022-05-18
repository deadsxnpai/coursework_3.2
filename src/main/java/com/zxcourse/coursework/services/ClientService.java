package com.zxcourse.coursework.services;

import com.zxcourse.coursework.entities.ClientEntity;
import com.zxcourse.coursework.exceptions.ClientNotFoundException;
import com.zxcourse.coursework.exceptions.UserAlreadyExist;
import com.zxcourse.coursework.models.ClientModel;
import com.zxcourse.coursework.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public ClientEntity createClient(ClientEntity clientEntity) throws UserAlreadyExist {
        if(clientRepo.findByLogin(clientEntity.getLogin()) != null){
            throw new UserAlreadyExist("Такой пользователь существует");
        }
        return clientRepo.save(clientEntity);
    }

    public long deleteClient(long id){
        clientRepo.deleteById(id);
        return id;
    }

    public ClientModel getOne(long id) throws ClientNotFoundException {
        ClientEntity clientEntity = clientRepo.findById(id).get() ;
        if(clientEntity == null){
            throw new ClientNotFoundException("Клиент не найден");
        }
        return ClientModel.toModel(clientEntity);
    }
}
