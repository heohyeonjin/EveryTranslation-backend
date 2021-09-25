package com.example.hanium.controller;

import com.example.hanium.dto.LoginSuccessDto;
import com.example.hanium.dto.SignInRequestDto;
import com.example.hanium.dto.SignupRequestDto;
import com.example.hanium.model.User;
import com.example.hanium.repository.UserRepository;
import com.example.hanium.service.UserService;
import com.example.hanium.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.hanium.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/user/signup")
    public List<User> checkUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return requestDto.getName();
    }

    @PostMapping("/user/login")
    public ApiResult<LoginSuccessDto> loginUser(@RequestBody SignInRequestDto requestDto) {
        User user = userService.loginUser(requestDto);

        LoginSuccessDto lsd = new LoginSuccessDto(user.getId(), user.getUsername());
        if (user == null) {
            return null;
        }

        return success(lsd);
    }
}