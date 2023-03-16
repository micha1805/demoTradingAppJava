package com.trading.app.demo.controller;

import com.trading.app.demo.model.User;
import com.trading.app.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    // @Autowired annotation is a Spring tool to deal with Dependency Injection :
    // the studentService instance will automatically be injected into the constructor
    // BUT studentService MUST BE A JAVA BEAN, as so we must annotate studentservice with @Component for that to work
    // As our StudentService class is also a service we will instead annotate it with @Service for more readability

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getStudents(){
        return userService.getUsers();

    }

}





