package com.trading.app.demo.httprequestsformat;

import lombok.Data;

@Data
public class TradePost {
    private Integer quantity;
    private String symbol;
}
