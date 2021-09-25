package com.example.hanium.email.service;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    public void sendMail(String to,String sub, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 수신자 설정
        message.setSubject(sub); // 메일 제목
        message.setText(text); //메일 내용
        emailSender.send(message);
    }
}
