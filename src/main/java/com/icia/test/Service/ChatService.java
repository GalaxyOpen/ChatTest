package com.icia.test.Service;

import com.icia.test.DTO.ChatMessageDetailDTO;
import com.icia.test.DTO.ChatRoomDetailDTO;

import java.util.List;

public interface ChatService {
    List<ChatRoomDetailDTO> findAllRooms();

    ChatRoomDetailDTO findRoomById(String id);
    //채팅방 생성하기
    void createChatRoomDTO(String name, int password, String chatMentor);

    void deleteById(Long chatRoomId);

    List<ChatMessageDetailDTO> findAllChatByRoomId(String roomId);
}