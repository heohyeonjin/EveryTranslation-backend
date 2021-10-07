package com.example.hanium.room.repository;

import com.example.hanium.Auth.model.User;
import com.example.hanium.room.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomId(Long RoomId);
}