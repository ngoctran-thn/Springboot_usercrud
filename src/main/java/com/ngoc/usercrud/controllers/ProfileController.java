package com.ngoc.usercrud.controllers;

import com.ngoc.usercrud.entities.Profile;
import com.ngoc.usercrud.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    //Try http://localhost:8080/profiles
    @GetMapping("/profiles")
    public Iterable<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    //Try http://localhost/profile/2
    @GetMapping("/profile/{id}")
    public Optional<Profile> getProfile(@PathVariable("id") int id){
        return profileRepository.findById(id);
    }

    @PostMapping("/profile")
    //Use postman and url http://localhost/profle, method POST and put {"name":"Test"} in body
    public Profile save(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }

    //update = save
    @PutMapping("/profile")
    //Use postman and url http://localhost/profle, method PUT and put {"id":6, "name":"Test2"} in body
    public Profile update(@RequestBody Profile profile){
        return profileRepository.save(profile);
    }

    @DeleteMapping("/profile")
    //Use postman and url http://localhost/profle, method DELETE and put {"id":6} in body
    public void delete(@RequestBody Profile profile){
        profileRepository.delete(profile);
    }
}
