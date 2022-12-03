package com.example.springchat.service;

import com.example.springchat.entity.ChatMessage;

import java.util.Collection;

public interface ChatMessageService {

    ChatMessage save(ChatMessage message);

    Collection<ChatMessage> getAll();
}
