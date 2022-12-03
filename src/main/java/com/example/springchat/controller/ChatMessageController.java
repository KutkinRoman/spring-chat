package com.example.springchat.controller;

import com.example.springchat.entity.ChatMessage;
import com.example.springchat.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll(){
        Collection<ChatMessage> messages = chatMessageService.getAll ();
        return ResponseEntity.ok (messages);
    }
}
