package com.example.hanium.chat.repository;

import com.example.hanium.chat.model.Chat;
import com.example.hanium.chat.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}