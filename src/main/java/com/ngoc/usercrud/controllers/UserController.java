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
    //Use postman and url http://localhost/user, method POST and put {"id":4, "name":"Test1", "email":"kkkkktka@gmail.com","phone":"12345678", "profile":{"id":2}} in body
    public ResponseEntity<?> save(@RequestBody User user) {
        int profileId = user.getProfile().getId();
        Optional<Profile> optionalProfile = profileRepository.findById(profileId);
        if (optionalProfile.isEmpty()) {
            return new ResponseEntity<>("Profile ID " + profileId + " not found.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        user.setProfile(optionalProfile.get());
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @PutMapping("/user")
    //Use postman and url http://localhost/user, method PUT and put {"id":6, "name":"Test2", "email":"thjoo@gmail.com","phone":"09876543", "profile":{"id":2}} in body
    public User update(@RequestBody User user){

        return userRepository.save(user);
    }
    @DeleteMapping("/user")
    //Use postman and url http://localhost/user, method DELETE and put {"id":6} in body
    public void delete(@RequestBody User user){
        userRepository.delete(user);
    }

}
