package com.example.springchat.controller;

import com.example.springchat.entity.ChatMessage;
import com.example.springchat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final ChatMessageService chatMessageService;

    @MessageMapping("/message")
    @SendTo("/chat")
    public ChatMessage greeting (ChatMessage message) {
        final ChatMessage messageSave = chatMessageService.save (message);
        return messageSave;
    }
}
