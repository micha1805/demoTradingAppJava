package com.trading.app.demo.httpresponsesformat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.trading.app.demo.model.Trade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeIndexResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Trade> trades;
}
