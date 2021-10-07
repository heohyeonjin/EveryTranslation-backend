package com.example.hanium.room.model;

import com.example.hanium.Auth.model.User;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "room_member_id")
    private Long roomMemberId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public void setUser(User user) {
        this.user = user;
        user.getRoomMembers().add(this);
    }

    public void setRoom(Room room){
        this.room = room;
        room.getRoomMembers().add(this);
    }

    public RoomMember(User user, Room room){
        setUser(user);
        setRoom(room);
    }
}
