package com.ngoc.usercrud.controllers;

import com.ngoc.usercrud.entities.Profile;
import com.ngoc.usercrud.entities.User;
import com.ngoc.usercrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //Try http://localhost:8080/users
    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
    //Try http://localhost/user/2
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userRepository.findById(id);
    }

}
