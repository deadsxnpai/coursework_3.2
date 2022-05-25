package com.zxcourse.coursework.controllers;

import com.zxcourse.coursework.entities.ClientEntity;
import com.zxcourse.coursework.exceptions.ClientNotFoundException;
import com.zxcourse.coursework.exceptions.UserAlreadyExist;
import com.zxcourse.coursework.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity createClient(@RequestBody ClientEntity clientEntity) {
        try {
            clientService.createClient(clientEntity);
            return ResponseEntity.ok().body("Client added");
        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body("User exception\n" + e);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong\n" + e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable long id){
        try {
            return ResponseEntity.ok().body(clientService.deleteClient(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping
    public ResponseEntity getOne(@RequestParam long id) {
        try {
            return ResponseEntity.ok().body(clientService.getOne(id));
        } catch (ClientNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
