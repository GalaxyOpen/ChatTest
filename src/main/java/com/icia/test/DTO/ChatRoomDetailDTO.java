package com.icia.test.DTO;

import com.icia.test.Entity.ChatRoomEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDetailDTO {
    private Long id;
    private String roomId;
    private String name;

    public static ChatRoomDetailDTO toChatRoomDetailDTO(ChatRoomEntity chatRoomEntity){
        ChatRoomDetailDTO chatRoomDetailDTO = new ChatRoomDetailDTO();
        chatRoomDetailDTO.setId(chatRoomEntity.getId());
        chatRoomDetailDTO.setRoomId(chatRoomEntity.getRoomId());
        chatRoomDetailDTO.setName(chatRoomEntity.getRoomName());
        return chatRoomDetailDTO;
    }

}
