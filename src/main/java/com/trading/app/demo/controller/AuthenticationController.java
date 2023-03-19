package com.trading.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @GetMapping(path="/login")
    public String login(){
        return "LOGIN ENDPOINT";
    }

    @PostMapping(path="/signup")
    public String signup(){
        return "SIGNUP ENDPOINT";
    }
}
