package com.example.hanium.chat.controller;

import com.example.hanium.chat.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessageSendingOperations template; //특정 브로커로 메세지 전달

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatDto message) {
        message.setMessage(message.getName() + "님이 미팅에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void message(ChatDto message) {
        System.out.println("message  = " + message);
            template.convertAndSend("/topic/room/" + message.getRoomId(), message);
    }
}
