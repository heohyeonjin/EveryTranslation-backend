package com.example.hanium.Auth.dto;

import lombok.Data;

@Data
public class LoginSuccessDto {
    private Long userId;
    private String userName;

    public LoginSuccessDto(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}