package com.example.hanium.room.repository;

import com.example.hanium.room.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
    RoomMember findByRoomMemberId(Long RoomMemberId);
}
