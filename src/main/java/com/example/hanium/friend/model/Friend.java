package com.example.hanium.friend.model;

import com.example.hanium.Auth.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
public class Friend {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="friend_id")
    private Long id;


    @OneToOne(targetEntity = User.class,fetch= FetchType.LAZY) //요청하는 순간 entity 정보
    @JoinColumn(name="newfriend_id")
    private User friend; //외래키

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name="my_id")
    private User user;

    public Friend(User user, User friend){
        this.user = user;
        this.friend = friend;
    }

    //친구 추가
   public static Friend createFriendShip(User me, User friend){
        Friend newfriend = new Friend(me,friend);
        me.getFriends().add(newfriend);
        return newfriend;
    }







}
