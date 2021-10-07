package com.example.hanium.chat.service;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.chat.model.Chat;
import com.example.hanium.chat.repository.ChatRepository;
import com.example.hanium.room.model.Room;
import com.example.hanium.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public Chat createChat(Long userId, Long roomId, String content) {
        User user = userRepository.findByUserId(userId);
        Room room = roomRepository.findByRoomId(roomId);
        return new Chat(user, room, content, user.getLanguage());
    }

    public Chat chatSave(Chat chat) {
        chatRepository.save(chat);
        return chat;
    }

}
