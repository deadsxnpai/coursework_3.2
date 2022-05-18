package com.zxcourse.coursework.repos;

import com.zxcourse.coursework.entities.ScooterEntity;
import org.springframework.data.repository.CrudRepository;

public interface ScooterRepo extends CrudRepository<ScooterEntity, Long> {
}
