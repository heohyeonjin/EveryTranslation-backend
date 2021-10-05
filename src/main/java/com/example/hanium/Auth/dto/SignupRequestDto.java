package com.example.hanium.Auth.dto;

import com.example.hanium.Auth.model.UserLanguage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String name;
    private String password;
    private String email;
    private UserLanguage language;
    private String phone;
}
