package com.example.hanium.Auth.controller;

import com.example.hanium.Auth.dto.LoginSuccessDto;
import com.example.hanium.Auth.dto.SignInRequestDto;
import com.example.hanium.Auth.dto.SignupRequestDto;
import com.example.hanium.Auth.dto.VerifyEmailDto;
import com.example.hanium.email.service.AuthService;
import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.Auth.service.UserService;
import com.example.hanium.utils.ApiUtils.ApiResult;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.hanium.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final AuthService authService;

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

        LoginSuccessDto lsd = new LoginSuccessDto(user.getUserId(), user.getUsername(), user.getLanguage());
        if (user == null) {
            return null;
        }

        return success(lsd);
    }

    // 회원가입 인증번호 발급
    @GetMapping("/user/verify/{requestEmail}")
    public ApiResult<String> verify(@PathVariable("requestEmail") String requestEmail) throws NotFoundException {
        authService.sendVerificationMail(requestEmail);
        return success("성공적으로 인증메일을 보냈습니다.");
    }

    // 인증번호 확인
    @PostMapping("/user/verify")
    public ApiResult<String> getVerify(@RequestBody VerifyEmailDto verifyEmailDto) throws IllegalStateException{
        String permissionCode = authService.verifyEmail(verifyEmailDto);
        return success(permissionCode);
    }
}