package com.example.hanium.roomMember.controller;

import com.example.hanium.friend.dto.EmailDto;
import com.example.hanium.room.model.Room;
import com.example.hanium.roomMember.service.RoomMemberService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.hanium.utils.ApiUtils.ApiResult;

import static com.example.hanium.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
public class RoomMemberController {

    final private RoomMemberService roomMemberService;

    // 미팅 시작 버튼 -> 미팅룸 생성
    @PostMapping("/room/create/{userId}")
    public ApiResult<String> createRoom(@PathVariable("userId") Long userId) {
        roomMemberService.createRoom(userId);
        return success("성공적으로 방을 생성했습니다.");
    }

    // 친구 초대
    @GetMapping("/room/invite/{fromId}/{toId}/{roomId}")
    public boolean inviteRoom(@PathVariable("fromId") Long fromId, @PathVariable("toId") Long toId, @PathVariable("roomId") Long roomId) {
        return roomMemberService.inviteRoom(fromId, toId, roomId);
    }

    // 이메일로 미팅 상대 초대
    @PostMapping("/room/invite/{roomId}")
    public boolean inviteRoom(@PathVariable Long roomId, @RequestBody EmailDto emailDto){
        return roomMemberService.inviteRoomByEmail(roomId,emailDto.getEmail());
    }


    // userID의 특정 미팅룸 삭제
    @DeleteMapping("/room/{userId}/{roomId}")
    public Room deleteRoom(@PathVariable("userId") Long userId, @PathVariable("roomId") Long roomId) {
        return roomMemberService.deleteRoom(userId, roomId);
    }
}
