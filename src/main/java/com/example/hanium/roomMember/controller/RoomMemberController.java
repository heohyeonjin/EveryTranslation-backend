package com.example.hanium.roomMember.controller;

import com.example.hanium.room.model.Room;
import com.example.hanium.roomMember.service.RoomMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomMemberController {

    final private RoomMemberService roomMemberService;

    // 미팅 시작 버튼 -> 미팅룸 생성
    @PostMapping("/room/create/{userId}")
    public Long createRoom(@PathVariable("userId") Long userId) {
        return roomMemberService.createRoom(userId);
    }

    // 미팅상대 추가
    @PostMapping("/room/invite/{fromId}/{toId}/{roomId}")
    public Long inviteRoom(@PathVariable("fromId") Long fromId, @PathVariable("toId") Long toId, @PathVariable("roomId") Long roomId) {
        return roomMemberService.inviteRoom(fromId, toId, roomId);
    }

    // userID의 특정 미팅룸 삭제
    @DeleteMapping("/room/{userId}/{roomId}")
    public Room deleteRoom(@PathVariable("userId") Long userId, @PathVariable("roomId") Long roomId) {
        return roomMemberService.deleteRoom(userId, roomId);
    }
}
