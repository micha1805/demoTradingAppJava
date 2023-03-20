package com.trading.app.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trade")
public class TradeController {

    // insert user Id in request
    @GetMapping(path = "/index")
    public String index(){
        return "ALL trades of user";
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
