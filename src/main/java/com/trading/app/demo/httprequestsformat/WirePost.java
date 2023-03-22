package com.trading.app.demo.httprequestsformat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class WirePost {
    private Integer amount_in_cent;
}
