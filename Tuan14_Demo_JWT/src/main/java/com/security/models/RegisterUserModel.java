package com.security.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserModel {
    private String email;
    private String password;
    private String fullName;
}
