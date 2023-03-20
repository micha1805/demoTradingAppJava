package com.trading.app.demo.httprequestsformat;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
}
