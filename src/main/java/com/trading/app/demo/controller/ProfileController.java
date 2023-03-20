package com.trading.app.demo.controller;

import com.trading.app.demo.httpresponsesformat.FullProfileResponse;
import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.User;
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

    @GetMapping
    public ResponseEntity<FullProfileResponse> getProfile( @RequestHeader("Authorization") String authHeader){

      // should take care of the case when no user is found:
        Optional<User> currentUser = userService.getUserByAuthHeader(authHeader);
        User user;
        FullProfileResponse response;
        if(currentUser.isPresent()){
            user = currentUser.get();
        }else{
            throw new IllegalArgumentException("User not found");
        }
        Profile profile = profileService.findByUserId(user.getId());

        // building the response object:
        response = FullProfileResponse.builder()
                .email(user.getEmail())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .address(profile.getAddress())
                .phoneNumber(profile.getPhoneNumber())
                .build();

        return ResponseEntity.ok(response);
    }

    // A method to test stuff :
    @GetMapping(path = "/test")
    public ResponseEntity<String> test(@RequestBody String requestBody, @RequestHeader("Authorization") String authHeader) {
        // I must find a way to do an equivalent of rails before_action to grab the user
        // before each method that need it. Java filter ?
        Optional<User> currentUser = userService.getUserByAuthHeader(authHeader);
        System.out.println(currentUser.toString());
        System.out.println(currentUser.get().getId());
        return ResponseEntity.ok( authHeader + requestBody);
    }

}
