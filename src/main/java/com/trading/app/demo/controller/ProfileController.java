package com.trading.app.demo.controller;

import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.ProfileRepository;
import com.trading.app.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;


    // Autowired constructor :
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }



    // LIST OF ENDPOINTS for the profile namespace :
    // GET api/v1/profile
    // get the all the details of the user and profile

    // Rem : Like so the url is : "/api/v1/profile"
    // It does NOT WORK it I got to "/api/v1/profile/" wih a slash at the end !!!
    // To map it like so I would have to write the annotation that way : @GetMapping("/")
    @GetMapping
    public Profile getProfile(){

        Long userId = 1L; // should get that from the user id from the request's body
        return profileService.findByUserId(userId);
    }

    // jut checking how to read the request's body :
    @GetMapping(path = "/test")
    public String test(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "hello !";
    }

}
