package com.trading.app.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wire")
public class WireController {


    @PostMapping
    public String createWire(@RequestBody String request){

        return request;
    }
}
