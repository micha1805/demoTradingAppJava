package com.trading.app.demo.service;

import com.trading.app.demo.model.Trade;
import com.trading.app.demo.model.User;
import com.trading.app.demo.repository.TradeRepository;
import com.trading.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    @Autowired
    public TradeService(TradeRepository tradeRepository){
        this.tradeRepository = tradeRepository;
    }
    public List<Trade> getTrades(){
        return tradeRepository.findAll();
    };

}
