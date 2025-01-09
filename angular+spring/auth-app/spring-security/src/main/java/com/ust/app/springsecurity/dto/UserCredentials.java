package com.ust.app.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserCredentials {

    private String username;
    private String password;

}
