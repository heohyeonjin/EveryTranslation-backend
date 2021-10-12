package com.example.hanium.friend.repository;



import com.example.hanium.Auth.model.User;
import com.example.hanium.friend.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend,Long> {
    User findByUser(User user);
}

