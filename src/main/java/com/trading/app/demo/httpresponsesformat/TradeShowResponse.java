package com.trading.app.demo.httpresponsesformat;

import com.trading.app.demo.model.Trade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeShowResponse {
    private Trade trade;
}
