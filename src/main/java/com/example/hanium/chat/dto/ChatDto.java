package com.example.hanium.chat.dto;

import com.example.hanium.Auth.model.UserLanguage;
import com.example.hanium.chat.model.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChatDto {
    private Long roomId;
    private Long userId;
    private Long chatId;
    private String message;     //메세지
    private UserLanguage language;    //사용언어

    public ChatDto(Chat chat) {
        this.roomId = chat.getRoom().getRoomId();
        this.userId = chat.getUser().getUserId();
        this.chatId = chat.getChatID();
        this.message = chat.getMessage();
        this.language = chat.getLanguage();
    }
}
