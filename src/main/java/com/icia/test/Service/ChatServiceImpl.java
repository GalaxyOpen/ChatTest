package com.icia.test.Service;

import com.icia.test.DTO.ChatMessageDetailDTO;
import com.icia.test.DTO.ChatRoomDTO;
import com.icia.test.DTO.ChatRoomDetailDTO;
import com.icia.test.Entity.ChatMessageEntity;
import com.icia.test.Entity.ChatRoomEntity;
import com.icia.test.Repository.ChatRepository;
import com.icia.test.Repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService{
    private final ChatRoomRepository crr;
    private final ChatRepository cr;

    //채팅방 전체보기
    @Override
    public List<ChatRoomDetailDTO> findAllRooms(){
        List<ChatRoomEntity> chatRoomEntityList = crr.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ChatRoomDetailDTO> chatRoomList = new ArrayList<>();

        for (ChatRoomEntity c : chatRoomEntityList){
            chatRoomList.add(ChatRoomDetailDTO.toChatRoomDetailDTO(c));
        }

        return chatRoomList;
    }
    // 채팅방 Id로 채팅방찾기
    @Override
    public ChatRoomDetailDTO findRoomById(String roomId){
        ChatRoomEntity chatRoomEntity = crr.findByRoomId(roomId);
        ChatRoomDetailDTO chatRoomDetailDTO = ChatRoomDetailDTO.toChatRoomDetailDTO(chatRoomEntity);
        return chatRoomDetailDTO;
    }

    //채팅방 생성하기
    @Override
    public void createChatRoomDTO(String name, int password, String chatMentor){
        ChatRoomDTO room = ChatRoomDTO.create(name);
        ChatRoomEntity chatRoomEntity = ChatRoomEntity.toChatRoomEntity(room.getName(),password,room.getRoomId(),chatMentor);
        crr.save(chatRoomEntity);
    }

    @Override
    public void deleteById(Long chatRoomId) {
        crr.deleteById(chatRoomId);
    }

    //채팅 이력 보여주기
    @Override
    public List<ChatMessageDetailDTO> findAllChatByRoomId(String roomId) {
        List<ChatMessageEntity> chatMessageEntityList = cr.findAllByChatRoomEntity_RoomId(roomId);
        List<ChatMessageDetailDTO> chatMessageList = new ArrayList<>();
        for (ChatMessageEntity c:chatMessageEntityList){
            chatMessageList.add(ChatMessageDetailDTO.toChatMessageDetailDTO(c));
        }
        return chatMessageList;
    }


}