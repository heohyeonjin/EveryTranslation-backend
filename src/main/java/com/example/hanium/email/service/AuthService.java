package com.example.hanium.email.service;

import com.example.hanium.Auth.dto.VerifyEmailDto;
import com.example.hanium.email.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final RedisUtil redisUtil;
    private final EmailService emailService;
    //이메일 인증번호 요청
    public void sendVerificationMail(String email) {
        int authentication = (int)(Math.random()*1000000);
        String content = "인증번호 : " + authentication ;
        redisUtil.setDataExpire(authentication+"",email, 60 * 3L);
        emailService.sendMail(email, "[WAW 앱] 회원가입을 위한 인증메일 입니다.", content);
        log.info(content);
    }

    // 이메일 인증번호 확인
    public String verifyEmail(VerifyEmailDto verifyEmailDto) throws IllegalStateException {
        String email = redisUtil.getData(verifyEmailDto.getCode());
        if(email == null) throw new IllegalStateException("인증번호가 올바르지 않습니다.");
        if(email.equals(verifyEmailDto.getEmail())) {
            int permissionCode = (int)(Math.random()*1000000);
            redisUtil.deleteData(verifyEmailDto.getCode());
            redisUtil.setDataExpire(permissionCode+"",verifyEmailDto.getEmail(), 60 * 3L);
            return permissionCode+"";
        }
        else {
            redisUtil.deleteData(verifyEmailDto.getCode());
            throw new IllegalStateException("인증번호가 올바르지 않습니다.");
        }
    }
}
