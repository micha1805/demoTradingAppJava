package com.trading.app.demo.controller;

import com.trading.app.demo.httprequestsformat.WirePost;
import com.trading.app.demo.model.User;
import com.trading.app.demo.model.Wire;
import com.trading.app.demo.repository.WireRepository;
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

    private final WireRepository wireRepository;

    @PostMapping
    public void createWire(@RequestBody WirePost request, @RequestHeader("Authorization") String authHeader){

        User user = userService.getUserFromHeader(authHeader);
        System.out.println(user);
        System.out.println(request.getAmount_in_cent().getClass());
        Wire newWire = Wire.builder()
                .amount(request.getAmount_in_cent())
                .build();
        wireRepository.save(newWire);
    }
}
