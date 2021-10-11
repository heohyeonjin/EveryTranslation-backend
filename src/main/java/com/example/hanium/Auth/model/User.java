package com.example.hanium.Auth.model;

import com.example.hanium.friend.model.Friend;
import com.example.hanium.chat.model.Chat;
import com.example.hanium.roomMember.model.RoomMember;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor // 기본생성자 생성
@Entity // DB 테이블 역할
public class User extends Timestamped {



    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long userId;

    // 반드시 값 가져야 함
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserLanguage language;

    @Column(nullable = true)
    private String phone;

    //친구
    @OneToMany(mappedBy = "user")
    private List<Friend> friends;

    @OneToMany(mappedBy = "user")
    private List<RoomMember> roomMembers = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Chat> messages;

    public User(String username, String password, String email, UserLanguage language, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.language = language;
        this.phone = phone;
    }
}
