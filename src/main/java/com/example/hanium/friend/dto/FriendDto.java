package com.example.hanium.friend.dto;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.model.UserLanguage;
import com.example.hanium.friend.model.Friend;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendDto {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private UserLanguage language;

    public FriendDto(Friend friend){
        User user = friend.getFriend();
        this.userId = user.getUserId();
        this.name = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.language = user.getLanguage();

//        if(user.getStatusMessage() != null)
//            this.statusMessage = user.getStatusMessage();
//
//        if(user.getProfileImage() != null)
//            this.profileImage = user.getProfileImage();
    }

}
