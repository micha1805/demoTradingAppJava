package com.trading.app.demo.httpresponsesformat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FullProfileResponse {
      private String email;
      private String firstName;
      private String lastName;
      private String address;
      private String phoneNumber;
}
