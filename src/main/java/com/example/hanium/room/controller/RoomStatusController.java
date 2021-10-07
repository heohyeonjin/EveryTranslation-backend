package com.example.hanium.room.controller;

import com.example.hanium.room.model.Room;
import com.example.hanium.room.service.RoomStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomStatusController {

    final private RoomStatusService roomStatusService;

    @GetMapping("/room/all")
    public List<Room> allRoom() {
        return roomStatusService.showAllRoom();
    }

    @PostMapping("/room/create/{userId}")
    public Long enterMeeting(@PathVariable("userId") Long userId) {
        return roomStatusService.createRoom(userId);
    }
}
