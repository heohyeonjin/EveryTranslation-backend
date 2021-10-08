package com.example.hanium.roomMember.model;

import com.example.hanium.Auth.model.User;
import com.example.hanium.room.model.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RoomMember {

    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roomMember_id")
    private Long roomMemberId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // 연관관계 편의 메서드
    public void setUser(User user) {
        // 기존의 roomMember/User 관계 끊기
        if (this.user != null) {
            this.user.getRoomMembers().remove(this);
        }
        this.user = user;   // roomMember -> user
        user.getRoomMembers().add(this);    // user -> roomMember
    }

    // 연관관계 편의 메서드
    public void setRoom(Room room){
        if (this.room != null) {
            this.room.getRoomMembers().remove(this);
        }
        this.room = room;   // roomMember -> room
        room.getRoomMembers().add(this);    // room -> roomMember
    }

    public RoomMember(User user, Room room){
        setUser(user);
        setRoom(room);
    }
}
