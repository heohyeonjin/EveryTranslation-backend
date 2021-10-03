package com.example.hanium.chat.model;

import com.example.hanium.Auth.model.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor // 기본생성자 생성
@Entity // DB 테이블 역할
public class ChatRoom extends Timestamped {

    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String madeBy;

    @Column(nullable = true)
    private String title;
}
