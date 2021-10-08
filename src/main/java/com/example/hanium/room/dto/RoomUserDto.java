package com.example.hanium.room.dto;

import com.example.hanium.Auth.model.UserLanguage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoomUserDto {
    Long userId;
    String username;
    UserLanguage language;

    public RoomUserDto(Long userId, String username, UserLanguage language) {
        this.userId = userId;
        this.username = username;
        this.language = language;
    }
}
