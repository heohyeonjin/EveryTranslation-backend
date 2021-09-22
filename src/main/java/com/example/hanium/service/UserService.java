package com.example.hanium.service;

import com.example.hanium.dto.SignupRequestDto;
import com.example.hanium.model.User;
import com.example.hanium.model.UserGender;
import com.example.hanium.model.UserLanguage;
import com.example.hanium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(SignupRequestDto requestDto) {
        String name = requestDto.getName();
        String password = requestDto.getPassword();
        String email = requestDto.getEmail();
        UserGender gender = requestDto.getGender();
        UserLanguage language = requestDto.getLanguage();

        User user = new User(name, password, email, gender, language);
        userRepository.save(user);
    }
}
