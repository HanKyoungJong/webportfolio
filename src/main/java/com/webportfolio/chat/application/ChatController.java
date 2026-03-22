package com.webportfolio.chat.presentation;

import com.webportfolio.chat.application.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/ask")
    public ChatResponse ask(@RequestBody ChatRequest request) {
        return new ChatResponse(chatService.ask(request.question()));
    }
}