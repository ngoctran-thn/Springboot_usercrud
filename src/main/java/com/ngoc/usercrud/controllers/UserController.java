package com.ngoc.usercrud.controllers;

import com.ngoc.usercrud.entities.Profile;
import com.ngoc.usercrud.entities.User;
import com.ngoc.usercrud.repositories.ProfileRepository;
import com.ngoc.usercrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;

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
    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        Optional<Profile> optionalProfile = profileRepository.findById(user.getProfile().getId());
        if (optionalProfile.isEmpty()) {
            return new ResponseEntity<>("Profile ID " + user.getProfile().getId() + " not found.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        user.setProfile(optionalProfile.get());
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
    }

}
