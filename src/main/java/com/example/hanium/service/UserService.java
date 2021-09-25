package com.example.hanium.service;

import com.example.hanium.dto.SignInRequestDto;
import com.example.hanium.dto.SignupRequestDto;
import com.example.hanium.model.User;
import com.example.hanium.model.UserLanguage;
import com.example.hanium.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public void registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getName();
        String email = requestDto.getEmail();
        UserLanguage language = requestDto.getLanguage();

        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username, password, email, language);
        userRepository.save(user);
    }


    // 로그인
    public User loginUser(SignInRequestDto requestDto) {
        User user = null;

        String userEmail = requestDto.getEmail();
        User findUser = userRepository.findByEmail(userEmail);

        // user 존재하지 않을경우
        if (findUser == null)
            return user;

        // 비밀번호 일치 확인
        if (passwordEncoder.matches(requestDto.getPassword(), findUser.getPassword())) {
            user = findUser;
        }

        return user;
    }
}
