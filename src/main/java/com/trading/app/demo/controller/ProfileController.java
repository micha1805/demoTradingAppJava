package com.trading.app.demo.controller;

import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.User;
import com.trading.app.demo.service.JwtService;
import com.trading.app.demo.service.ProfileService;
import com.trading.app.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final UserService userService;
    private final JwtService jwtService;

    // LIST OF ENDPOINTS for the profile namespace :
    // GET api/v1/profile
    // get the all the details of the user and profile

    // Rem : Like so the url is : "/api/v1/profile"
    // It does NOT WORK it I got to "/api/v1/profile/" wih a slash at the end !!!
    // To map it like so I would have to write the annotation that way : @GetMapping("/")
    @GetMapping
    public Profile getProfile(){

        Long userId = 123L; // should get that from the user id from the request's body
        return profileService.findByUserId(userId);
    }

    // jut checking how to read the request's body :
    @GetMapping(path = "/test")
    public ResponseEntity<String> test(@RequestBody String requestBody, @RequestHeader("Authorization") String authHeader) {
        System.out.println(requestBody);
        System.out.println(authHeader);
        Optional<User> currentUser = userService.getUserByAuthHeader(authHeader);
        System.out.println(currentUser.toString());
        return ResponseEntity.ok( authHeader);
    }

}
