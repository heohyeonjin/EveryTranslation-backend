package com.example.hanium.controller;

import com.example.hanium.dto.SignupRequestDto;
import com.example.hanium.model.User;
import com.example.hanium.repository.UserRepository;
import com.example.hanium.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/user/signup")
    public List<User> checkusers() {return userRepository.findAll();}

    @PostMapping("/user/signup")
   public String registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
       return requestDto.getName();
    }
}