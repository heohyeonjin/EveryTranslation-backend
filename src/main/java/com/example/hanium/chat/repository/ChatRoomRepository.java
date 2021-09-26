package com.example.hanium.chat.repository;

import com.example.hanium.chat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    List<ChatRoom> findAll();

    ChatRoom findChatRoomById(Long id);
}