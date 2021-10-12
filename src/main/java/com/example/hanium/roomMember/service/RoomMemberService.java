package com.example.hanium.roomMember.service;

import com.example.hanium.Auth.model.User;
import com.example.hanium.Auth.repository.UserRepository;
import com.example.hanium.friend.model.Friend;
import com.example.hanium.friend.repository.FriendRepository;
import com.example.hanium.room.model.Room;
import com.example.hanium.roomMember.model.RoomMember;
import com.example.hanium.roomMember.repository.RoomMemberRepository;
import com.example.hanium.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomMemberService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final FriendRepository friendRepository;

    // 미팅 시작 버튼
    @Transactional
    public Long createRoom(Long userId) {
        User user = userRepository.findByUserId(userId);

        // 새로운 미팅룸 생성 및 저장
        Room room = new Room(user.getUsername());
        roomRepository.save(room);

        // 미팅룸 생성자를 미팅룸에 추가
        joinRoom(user, room);

        return room.getRoomId();
    }

    /* --------------------------------------------------------
    fromId(초대하는사람) 친구 대상에서 toId(초대받는사람) 존재 여부 확인
    -> 존재 할 경우 join room 실행하도록 코드 변경
     ------------------------- */

    //친구 초대

    @Transactional
    public boolean inviteRoom(Long fromId, Long toId, Long roomId) {
        User from = userRepository.findByUserId(fromId);
        Room room = roomRepository.findByRoomId(roomId);

        // 친구 대상에 toId 존재 하면
        Optional<Friend> first = from.getFriends().stream()
                .filter(a -> a.getFriend().getUserId() == toId)
                .findFirst();

        // Join room
        if (first.isPresent()) {
            Friend friend = first.get();
            Friend to = friendRepository.findById(friend.getId()).orElseThrow(
                    () -> new NullPointerException("접근 오류")
            );
            User to_ = to.getFriend();
            joinRoom(to_, room);
            return true;
        }

        return false;
    }

    // 이메일로 친구 초대
    @Transactional
    public boolean inviteRoomByEmail(Long roomId, String friendEmail) {
        User friend = userRepository.findByEmail(friendEmail);
        Room room = roomRepository.findByRoomId(roomId);

        if(friend != null){
            joinRoom(friend,room);
            return true;
        }
        return false;
    }

    // userID의 특정 미팅룸 삭제
    public Room deleteRoom(Long userId, Long roomId) {
        User user = userRepository.findByUserId(userId);
        Room room = roomRepository.findByRoomId(roomId);
        RoomMember roomMember = roomMemberRepository.findByUserAndRoom(user, room);
        roomMemberRepository.delete(roomMember);

        return room;
    }

    // 나를 미팅룸에 추가
    public void joinRoom(User user, Room room) {
        RoomMember roomMember = new RoomMember(user, room);
        roomMemberRepository.save(roomMember);
    }

}