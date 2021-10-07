package com.example.hanium.room.dto;

import com.example.hanium.Auth.model.UserLanguage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoomDto {
    Long roomId;
    String roomName;
    String content;
    String recentTime;
    UserLanguage language;

    public RoomDto(Long roomId, String roomName, String content, String recentTime, UserLanguage language) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.content = content;
        this.recentTime = recentTime;
        this.language = language;
    }
}
