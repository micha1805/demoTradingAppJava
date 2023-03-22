package com.trading.app.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TradeService {

    // TODO
    //  CREATE A REAL API CALL TO A STOCK PRICE PROVIDER !!!!
    //  THIS IS FOR NOW JUST HARDCODED.
    // I made it statis to use it in the computation of the
    public static Integer getStockPriceNow(String symbol) {
        return 100;
    }
}
