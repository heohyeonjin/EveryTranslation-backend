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
    String recentContent;
    String recentTime;

    public RoomDto(Long roomId, String roomName, String recentContent, String recentTime) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.recentContent = recentContent;
        this.recentTime = recentTime;
    }
}
