package com.example.hanium.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatDto {
    private String roomId;      //방번호
    private String name;        //보내는 사람
    private String message;     //메세지
    private String language;    //사용언어
}
