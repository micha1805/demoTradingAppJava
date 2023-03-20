package com.trading.app.demo.httprequestsformat;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private String first_name; // naming convention to fit JSON
    private String last_name;  // idem
    private String address;
    private String phone;
}
