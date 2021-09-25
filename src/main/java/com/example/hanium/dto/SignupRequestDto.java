package com.example.hanium.dto;

import com.example.hanium.model.UserLanguage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String name;
    private String password;
    private String email;
    private UserLanguage language;
}
