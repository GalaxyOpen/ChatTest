package com.icia.test.Controller;

import com.icia.test.DTO.ChatMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessageDTO sendMessage(@Payload ChatMessageDTO chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDTO addUser(@Payload ChatMessageDTO chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}

//@Controller
//@RequiredArgsConstructor
//public class StompChatController {
//
//    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
//    private final ChatRepository chatRepository;
//    private final ChatRoomRepository chatRoomRepository;
//    private final ChatService chatService;
//
//    //Client 가 SEND 할 수 있는 경로
//    //stompConfig 에서 설정한 applicationDestinationPrefixes 와 @MessageMapping 경로가 병합됨
//    //"/pub/chat/enter"
//    // 사용자가 들어옴
//    @MessageMapping(value = "/chat/enter")
//    public void enter(ChatMessageDetailDTO message) {
//        //set 되기 전 글쓴이
//        String enterMember = message.getWriter();
////        채팅이력 보여주기
//        List<ChatMessageDetailDTO> chatMessageDetailDTOList = chatService.findAllChatByRoomId(message.getRoomId());
//        if(!(chatMessageDetailDTOList.isEmpty())) {
//            for (ChatMessageDetailDTO c : chatMessageDetailDTOList) {
//                message.setWriter(c.getWriter());
//                message.setMessage(c.getMessage());
//                template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//            }
//            message.setMessage(enterMember+ "님이 채팅방에 참여하였습니다.");
//            message.setWriter(enterMember);
//            template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//        }else {
//            //        채팅방 참여 정보 알려주기
//            message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
//            System.out.println("들어온 메세지 : "+message);
//
//            template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//        }
////      채팅이력 저장하기
//        ChatMessageSaveDTO chatMessageSaveDTO = new ChatMessageSaveDTO(message.getRoomId(),message.getWriter(), message.getMessage());
//        ChatRoomEntity chatRoomEntity= chatRoomRepository.findByRoomId(message.getRoomId());
//        chatRepository.save(ChatMessageEntity.toChatEntity(chatMessageSaveDTO,chatRoomEntity));
//    }
//
//    //메시지를 보냄
//    @MessageMapping(value = "/chat/message")
//    public void message(ChatMessageDetailDTO message) {
//        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//        System.out.println("들어온 메세지 : "+message);
//
//        // DB에 채팅내용 저장
//        ChatRoomEntity chatRoomEntity= chatRoomRepository.findByRoomId(message.getRoomId());
//        ChatMessageSaveDTO chatMessageSaveDTO = new ChatMessageSaveDTO(message.getRoomId(),message.getWriter(), message.getMessage());
//
//
//        chatRepository.save(ChatMessageEntity.toChatEntity(chatMessageSaveDTO,chatRoomEntity));
//    }
//    @MessageMapping 을 통해 WebSocket 으로 들어오는 메세지 발행을 처리한다.
//    Client 에서는 prefix 를 붙여 "/pub/chat/enter"로 발행 요청을 하면
//    Controller 가 해당 메세지를 받아 처리하는데,
//    메세지가 발행되면 "/sub/chat/room/[roomId]"로 메세지가 전송되는 것을 볼 수 있다.
//    Client 에서는 해당 주소를 SUBSCRIBE 하고 있다가 메세지가 전달되면 화면에 출력한다.
//    이때 /sub/chat/room/[roomId]는 채팅방을 구분하는 값이다.
//    기존의 핸들러 ChatHandler 의 역할을 대신 해주므로 핸들러는 없어도 된다.
//}