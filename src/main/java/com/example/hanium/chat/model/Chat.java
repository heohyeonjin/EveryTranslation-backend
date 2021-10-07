package com.example.hanium.chat.model;

import com.example.hanium.Auth.model.Timestamped;
import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.model.UserLanguage;
import com.example.hanium.room.model.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Chat {

    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_id")
    private Long chatID;

    private String message; // 메세지

    private UserLanguage language;  // 언어

    private LocalDateTime writtenAt;  // 작성 시간간

    // 패치 타입 LAZY 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 패치 타입 LAZY 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
        room.getMessages().add(this);
    }

    public Chat(User user, Room room, String message, UserLanguage language) {
        this.setUser(user);
        this.setRoom(room);
        this.message = message;
        this.language = language;
    }
}