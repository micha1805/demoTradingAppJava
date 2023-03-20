package com.trading.app.demo.controller;

import com.trading.app.demo.httprequestsformat.LoginRequest;
import com.trading.app.demo.httpresponsesformat.AuthenticationResponse;
import com.trading.app.demo.httpresponsesformat.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @GetMapping(path="/login")
    public TestResponse login(@RequestBody LoginRequest loginRequest){

        // add try catch while getting info from the request, null is the value when
        // no corresponding keys
        // then try catch with getting the correct user

        System.out.println(loginRequest);
        System.out.println("email = " + loginRequest.getEmail());
        System.out.println("password = " + loginRequest.getPassword());


        return TestResponse.builder()
                .email("hello")
                .build();
    }

    @PostMapping(path="/signup")
    public String signup(){
        return "SIGNUP ENDPOINT";
    }
}
