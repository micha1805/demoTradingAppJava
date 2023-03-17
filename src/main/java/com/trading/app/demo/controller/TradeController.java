package com.trading.app.demo.controller;


import com.trading.app.demo.model.Trade;
import com.trading.app.demo.model.User;
import com.trading.app.demo.service.TradeService;
import com.trading.app.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trade")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/")
    public List<Trade> getTrades(){
        //return tradeService.getTrades();
        return List.of(
                new Trade(),
                new Trade()
        );
    }

    @GetMapping("/test")
    public String testString(){
        return "HELLLO";
    }
}
