package com.example.hanium.room.service;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.chat.model.Chat;
import com.example.hanium.room.dto.RoomDto;
import com.example.hanium.room.model.Room;
import com.example.hanium.room.repository.RoomRepository;
import com.example.hanium.roomMember.model.RoomMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    // userId가 속한 미팅룸 조회
    public List<RoomDto> showAllRoom(Long userId){
        User user = userRepository.findByUserId(userId);

        List<Room> rooms = user.getRoomMembers()
                .stream().map(RoomMember::getRoom)
                .collect(Collectors.toList());

        List<RoomDto> roomDtos = new ArrayList<>();

        rooms.forEach((room -> {
            Long roomId = room.getRoomId();
            String roomName = room.getRoomName();
            String recentContent = "";
            String recentTime = "";

            List<Chat> contents = room.getMessages();
            int size = contents.size();

            if (size != 0) {
                Chat content = contents.get(size - 1);
                recentContent = content.getMessage();
                recentTime = content.getWrittenAt().toString();
            }

            roomDtos.add(new RoomDto(roomId, roomName, recentContent, recentTime));
        }));

        return roomDtos;
    }
}
