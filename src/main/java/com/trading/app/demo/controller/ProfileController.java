package com.trading.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/profile")
public class ProfileController {



    // LIST OF ENDPOINTS for the profile namespace :
    // GET api/v1/profile
    // get the all the details of the user and profile

    // Rem : Like so the url is : "/api/v1/profile"
    // It does NOT WORK it I got to "/api/v1/profile/" wih a slash at the end !!!
    // To map it like so I would have to write the annotation that way : @GetMapping("/")
    @GetMapping
    public String getProfile(){
        return "GET profile";
    }
}
