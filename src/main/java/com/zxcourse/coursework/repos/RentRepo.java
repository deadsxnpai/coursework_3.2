package com.zxcourse.coursework.repos;

import com.zxcourse.coursework.entities.RentEntity;
import com.zxcourse.coursework.entities.ScooterEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentRepo extends CrudRepository<RentEntity, Long> {
}
