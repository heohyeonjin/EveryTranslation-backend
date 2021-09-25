package com.example.hanium.service;

import com.example.hanium.dto.SignInRequestDto;
import com.example.hanium.dto.SignupRequestDto;
import com.example.hanium.model.User;
import com.example.hanium.model.UserLanguage;
import com.example.hanium.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public void registerUser(SignupRequestDto requestDto) {
        String name = requestDto.getName();
        String password = requestDto.getPassword();
        String email = requestDto.getEmail();
        UserLanguage language = requestDto.getLanguage();

        User user = new User(name, password, email, language);
        userRepository.save(user);
    }

    // 로그인
    public User loginUser(SignInRequestDto requestDto) {
        User user = null;

        String userEmail = requestDto.getEmail();
        String userPassword = requestDto.getPassword();

        User findUser = userRepository.findByEmail(userEmail);

        // user 존재하지 않을경우
        if (findUser == null)
            return user;

        // 비밀번호 일치 확인
        if (findUser.getPassword().equals(userPassword)) {
            user = findUser;
        }

        return user;
    }
}
