package com.example.hanium.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat {
    private String ChatRoomId;  // 방번호
    private String name;        // 메세지 보낸 사람
    private String message;     // 메세지
    private String language;    // 언어
}
