package com.trading.app.demo.controller;

import com.trading.app.demo.httprequestsformat.UserUpdateRequest;
import com.trading.app.demo.httpresponsesformat.FullProfileResponse;
import com.trading.app.demo.model.Profile;
import com.trading.app.demo.model.User;
import com.trading.app.demo.service.ProfileService;
import com.trading.app.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;
    private final ProfileService profileService;
    private final PasswordEncoder passwordEncoder;

    // @Autowired annotation is a Spring tool to deal with Dependency Injection :
    // the studentService instance will automatically be injected into the constructor
    // BUT studentService MUST BE A JAVA BEAN, as so we must annotate studentservice with @Component for that to work
    // As our StudentService class is also a service we will instead annotate it with @Service for more readability

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();

    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateRequest request, @RequestHeader("Authorization") String authHeader) {

        // TODO
        //  - if no user found
        //  - if no profile found
        //  - if body's request is partial information (for now it is the full data)

        Optional<User> currentUser = userService.getUserByAuthHeader(authHeader);
        User user;

        if(currentUser.isPresent()){
            user = currentUser.get();
        }else{
            throw new IllegalArgumentException("User not found");
        }


        profileService.updateFullProfile(user.getId(), request);

        // TODO update user MUST BE OPTIMISED !!!!!
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.update(user);

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(user);
        System.out.println(user.getProfile());
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    @GetMapping(path = "currentBalance")
    public String getCurrentBalance(){
        return "current balance";
    }
}





