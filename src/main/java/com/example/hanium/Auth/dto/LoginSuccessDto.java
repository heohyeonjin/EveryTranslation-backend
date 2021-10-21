package com.example.hanium.Auth.dto;

import com.example.hanium.Auth.model.UserLanguage;
import lombok.Data;

@Data
public class LoginSuccessDto {
    private Long userId;
    private String userName;
    private UserLanguage userLanguage;

    public LoginSuccessDto(Long userId, String userName, UserLanguage language) {
        this.userId = userId;
        this.userName = userName;
        this.userLanguage = language;
    }
}