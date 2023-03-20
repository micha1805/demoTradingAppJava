package com.trading.app.demo.httprequestsformat;

import lombok.Data;

@Data
public class WirePost {
    private String amountInCent;
    private String withdrawal;
}
