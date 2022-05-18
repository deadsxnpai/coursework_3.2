package com.zxcourse.coursework.controllers;

import com.zxcourse.coursework.entities.ScooterEntity;
import com.zxcourse.coursework.exceptions.ScooterAlreadyExist;
import com.zxcourse.coursework.exceptions.ScooterNotFoundException;
import com.zxcourse.coursework.services.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scooter")
public class ScooterController {
    @Autowired
    private ScooterService scooterService;
    @PostMapping
    public ResponseEntity createScooter(@RequestBody ScooterEntity scooterEntity) {
        try {
            scooterService.createScooter(scooterEntity);
            return ResponseEntity.ok().body("Scooter added");
        } catch (ScooterAlreadyExist e) {
            return ResponseEntity.badRequest().body("Scooter already exist exception\n" + e);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong\n" + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScooter(@PathVariable long id){
        try {
            return ResponseEntity.ok().body(scooterService.deleteScooter(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam long id) {
        try {
            return ResponseEntity.ok().body(scooterService.getOne(id));
        } catch (ScooterNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
