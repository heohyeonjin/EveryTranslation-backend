package com.example.hanium.roomMember.repository;

import com.example.hanium.roomMember.model.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomMemberRepository extends JpaRepository<RoomMember, Long> {
    RoomMember findByRoomMemberId(Long RoomMemberId);
}
