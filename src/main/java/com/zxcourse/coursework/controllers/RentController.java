package com.zxcourse.coursework.controllers;

import com.zxcourse.coursework.entities.RentEntity;
import com.zxcourse.coursework.exceptions.RentAlreadyExist;
import com.zxcourse.coursework.exceptions.RentNotFoundException;
import com.zxcourse.coursework.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class RentController {
    @Autowired
    private RentService rentService;
    @PostMapping
    public ResponseEntity createRent(@RequestBody RentEntity rentEntity) {
        try {
            rentService.createRent(rentEntity);
            return ResponseEntity.ok().body("Rent added");
        } catch (RentAlreadyExist e) {
            return ResponseEntity.badRequest().body("Rent already exist exception\n" + e);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong\n" + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRent(@PathVariable long id){
        try {
            return ResponseEntity.ok().body(rentService.deleteRent(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam long id) {
        try {
            return ResponseEntity.ok().body(rentService.getOne(id));
        } catch (RentNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
