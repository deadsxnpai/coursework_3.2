package com.zxcourse.coursework.repos;

import com.zxcourse.coursework.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
    ClientEntity findByLogin(String login);
}
