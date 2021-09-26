package com.example.hanium.chat.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ChatRoomDto {
    private String roomId;
    private String madeBy;
    private String title;

    //WebSocketSession은 Spring에서 Websoket Connection이 맺어진 세션
    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomDto create(String title, String madeBy) {
        ChatRoomDto room = new ChatRoomDto();

        room.roomId = UUID.randomUUID().toString();
        room.title = title;
        room.madeBy = madeBy;

        return room;
    }
}
