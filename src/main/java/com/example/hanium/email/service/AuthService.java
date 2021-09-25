package com.example.hanium.email.service;

import com.example.hanium.email.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    // private final RedisUtil redisUtil;
    private final EmailService emailService;
    //이메일 인증번호 요청
    public void sendVerificationMail(String email) {
        int authentication = (int)(Math.random()*1000000);
        String content = "인증번호 : " + authentication ;
//        redisUtil.setDataExpire(authentication+"",email, 60 * 3L);
        emailService.sendMail(email, "[WAW 앱] 회원가입을 위한 인증메일 입니다.", content);
        log.info(content);
    }
}
