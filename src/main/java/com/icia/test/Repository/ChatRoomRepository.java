package com.icia.test.Repository;

import com.icia.test.Entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity,Long> {
    //    방 주소를 통해 ChatRoomEntity를 가져옴
    ChatRoomEntity findByRoomId(String roomId);
}
