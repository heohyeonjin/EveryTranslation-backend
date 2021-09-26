package com.example.hanium.chat.controller;

import com.example.hanium.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class ChatRoomController {

    private final ChatRoomRepository repository;

    // 채팅방 개설
//    @PostMapping("/room")
//    public String create(@RequestParam String name) {
//
//    }

}
