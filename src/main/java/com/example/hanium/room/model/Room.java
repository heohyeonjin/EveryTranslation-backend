package com.example.hanium.room.model;

import com.example.hanium.chat.model.Chat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room {

    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "room_id")
    private Long roomId;

    // 채팅방 타이틀
    private String roomName;

    // 채팅방 내 메시지 리스트
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Chat> messages;

    public Room(String name) {
        this.roomName = name;
    }
}
