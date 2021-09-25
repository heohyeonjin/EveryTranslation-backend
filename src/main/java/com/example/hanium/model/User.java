package com.example.hanium.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor // 기본생성자 생성
@Entity // DB 테이블 역할
public class User extends Timestamped {



    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값 가져야 함
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserLanguage language;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String img;

    public User(String name, String password, String email, UserLanguage language) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.language = language;
    }
}
