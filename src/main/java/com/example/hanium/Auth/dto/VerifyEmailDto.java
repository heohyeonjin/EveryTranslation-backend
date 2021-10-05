package com.example.hanium.Auth.dto;


import lombok.Data;

@Data
public class VerifyEmailDto {
    private String email;
    private String code;
}
