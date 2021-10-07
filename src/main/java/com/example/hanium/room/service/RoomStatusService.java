package com.example.hanium.room.service;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.room.model.Room;
import com.example.hanium.room.model.RoomMember;
import com.example.hanium.room.repository.RoomMemberRepository;
import com.example.hanium.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomStatusService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomMemberRepository roomMemberRepository;

    public List<Room> showAllRoom(){
        return roomRepository.findAll();
    }
    public Long createRoom(Long userId) {
        User user = userRepository.findByUserId(userId);
        Room room = new Room(user.getUsername());

        roomRepository.save(room);
        joinRoom(user, room);

        return room.getRoomId();
    }

    public void joinRoom(User user, Room room) {
        RoomMember roomMember = new RoomMember(user, room);
        roomMemberRepository.save(roomMember);
    }
}
