package com.trading.app.demo.controller;

import com.trading.app.demo.httpresponsesformat.TradeIndexResponse;
import com.trading.app.demo.httpresponsesformat.TradeShowResponse;
import com.trading.app.demo.model.Trade;
import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.TradeRepository;
import com.trading.app.demo.repository.UserRepository;
import com.trading.app.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trade")
public class TradeController {

    private final UserService userService;
    private final TradeRepository tradeRepository;
    private final UserRepository userRepository;
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
    public ResponseEntity<TradeShowResponse> getTrade(@RequestHeader("Authorization") String authHeader, @PathVariable String tradeId){
        User user = userService.getUserFromHeader(authHeader);
        Long tradeIdLong = Long.parseLong(tradeId);
        Trade trade = tradeRepository.findById(tradeIdLong)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Trade of id " + tradeIdLong + "not found"
                ));
        // validate tradeId if currentUser == trade.user
        if(trade.getUser().getId().equals(user.getId())){
            return ResponseEntity.ok(TradeShowResponse.builder().trade(trade).build());
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
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
