package com.example.hanium.friend.controller;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.Auth.service.UserService;
import com.example.hanium.friend.dto.EmailDto;
import com.example.hanium.friend.dto.FriendDto;
import com.example.hanium.friend.service.FriendService;
import com.example.hanium.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.hanium.utils.ApiUtils.success;

@RestController
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;
    private final UserRepository userRepository;


    //친구 추가
    @PostMapping("/api/friend/{myId}")
    public String addFriend(@PathVariable Long myId, @RequestBody EmailDto emailDto){
        return friendService.addFriend(myId, emailDto.getEmail());
    }

    // 친구 리스트
    @GetMapping("/api/friends/{myId}")
    public List<FriendDto> allFriends(@PathVariable Long myId){
        User user = userRepository.findById(myId).orElseThrow(
                ()->new NullPointerException("접근 오류")
        );
        return user.getFriends().stream()
                .map(o -> new FriendDto(o))
                .collect(Collectors.toList());
    }

    //친구 삭제
    @GetMapping("/api/friend/{myId}/{friendId}")
    public String deleteFriend(@PathVariable Long myId, @PathVariable Long friendId){
        return friendService.deleteFriend(myId,friendId);
    }

}
