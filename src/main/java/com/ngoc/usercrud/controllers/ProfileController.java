package com.ngoc.usercrud.controllers;

import com.ngoc.usercrud.entities.Profile;
import com.ngoc.usercrud.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    //Try http://localhost:8080/profiles
    @GetMapping("/profiles")
    public Iterable<Profile> getPersons(){
        return profileRepository.findAll();
    }
}
