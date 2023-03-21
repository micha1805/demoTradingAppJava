package com.trading.app.demo.controller;

import com.trading.app.demo.httpresponsesformat.TradeIndexResponse;
import com.trading.app.demo.model.Trade;
import com.trading.app.demo.repository.TradeRepository;
import com.trading.app.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trade")
public class TradeController {

    private final UserService userService;
    private final TradeRepository tradeRepository;
    // insert user Id in request
    @GetMapping(path = "/index")
    public ResponseEntity<TradeIndexResponse> tradeIndex(@RequestHeader("Authorization") String authHeader){


        // test list :
        List<Trade> trades = new ArrayList<>();
        trades.add(tradeRepository.findById(1L).orElse(null));
        trades.add(tradeRepository.findById(2L).orElse(null));
        trades.add(tradeRepository.findById(3L).orElse(null));



//        User user;
//        try{
//            user = userService.getUserFromHeader(authHeader);
//            trades = user.getTrades();
//        }catch(Exception e){
//            trades = new ArrayList<>();// empty list
//            System.out.println(e.getMessage());
//        }

        TradeIndexResponse response = TradeIndexResponse.builder().trades(trades).build();

        ResponseEntity<TradeIndexResponse> respEntity = ResponseEntity.ok(response);

        return respEntity;

    }

    // check that user is authorised to check that trade
    @GetMapping(path = "/{tradeId}")
    public String getTrade(@PathVariable String tradeId){
        // validate tradeId is an Id
        return "get trade of Id = " + tradeId;
    }

    @GetMapping(path = "/index/open")
    public String getAllOpenTrades(){
        return "fetch my open trades";
    }

    @GetMapping(path = "/index/closed")
    public String getAllClosedTrades(){
        return "fetch my closed trades";
    }

    @PostMapping(path = "/openTrade")
    public String createTrade(){
        // check balance in the validation
        return "POST a trade";
    }


    @PatchMapping(path = "/closeTrade/{tradeId}")
    public String closeTrade(@PathVariable String tradeId){
        // validate tradeID is an id
        // check balance in the validation
        return "PATCH a trade of ID = " + tradeId;
    }


    @GetMapping(path = "/closedPNL")
    public String closedPNL(){
        return "closed PNL";
    }

    @GetMapping(path = "/openPNL")
    public String openPNL(){
        return "open PNL";
    }


}
