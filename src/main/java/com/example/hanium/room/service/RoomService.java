package com.example.hanium.room.service;

import com.example.hanium.room.model.Room;
import com.example.hanium.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> showAllRoom(){
        return roomRepository.findAll();
    }
}
