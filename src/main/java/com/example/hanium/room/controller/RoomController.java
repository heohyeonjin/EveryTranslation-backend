package com.example.hanium.room.controller;

import com.example.hanium.room.model.Room;
import com.example.hanium.room.repository.RoomRepository;
import com.example.hanium.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomController {

    private final RoomService roomService;
    private final RoomRepository roomRepository;

    @GetMapping("/room/all")
    public List<Room> allRoom() {
        return roomService.showAllRoom();
    }
}
