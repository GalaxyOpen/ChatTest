package com.icia.test.Repository;

import com.icia.test.Entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessageEntity,Long> {
    // 방의 고유 주소를 통해 채팅이력을 모두 다 불러옴
    List<ChatMessageEntity> findAllByChatRoomEntity_RoomId(String roomId);
}
