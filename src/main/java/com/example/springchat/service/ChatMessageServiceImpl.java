package com.example.springchat.service;

import com.example.springchat.entity.ChatMessage;
import com.example.springchat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage save (ChatMessage message) {
        return chatMessageRepository.save (message);
    }

    @Override
    public Collection<ChatMessage> getAll () {
        return chatMessageRepository.findAll ();
    }
}
