package com.icia.test.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT, // Talk
        JOIN, //enter
        LEAVE
    }
}
