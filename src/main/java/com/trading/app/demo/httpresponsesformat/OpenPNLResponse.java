package com.trading.app.demo.httpresponsesformat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenPNLResponse {
    private Integer openPnlInCent;
}