package com.trading.app.demo.controller;

import com.trading.app.demo.httprequestsformat.WirePost;
import com.trading.app.demo.model.User;
import com.trading.app.demo.service.UserService;
import com.trading.app.demo.service.WireService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wire")
@Data
@RequiredArgsConstructor
public class WireController {

    private final UserService userService;
    private final WireService wireService;

    @PostMapping
    public void createWire(@RequestBody WirePost request, @RequestHeader("Authorization") String authHeader){

        User user = userService.getUserFromHeader(authHeader);
        System.out.println(request.toString());
    }
}
