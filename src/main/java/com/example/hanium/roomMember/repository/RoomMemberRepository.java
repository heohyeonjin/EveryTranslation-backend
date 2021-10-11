package com.example.hanium.roomMember.repository;

import com.example.hanium.Auth.model.User;
import com.example.hanium.room.model.Room;
import com.example.hanium.roomMember.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
    RoomMember findByUserAndRoom(User user, Room room);
}
