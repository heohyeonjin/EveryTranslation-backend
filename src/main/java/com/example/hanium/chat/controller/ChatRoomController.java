package com.example.hanium.chat.controller;

import com.example.hanium.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class ChatRoomController {

    private final ChatRepository repository;

    // 채팅방 개설
//    @PostMapping("/room")
//    public String create(@RequestParam String name) {
//
//    }

}
