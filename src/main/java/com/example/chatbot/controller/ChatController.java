package com.example.chatbot.controller;

import com.example.chatbot.model.Message;
import com.example.chatbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private MessageService chatService;

    // Show chat page with all messages
    @GetMapping
    public String chatPage(Model model) {
        List<Message> messages = chatService.getAllMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("newMessage", new Message());
        return "chat"; // loads chat.html (Thymeleaf)
    }

    // Send a new message
    @PostMapping("/send")
    public String sendMessage(@ModelAttribute("newMessage") Message message) {
        chatService.saveMessage(message);
        return "redirect:/chat"; // reload page with updated messages
    }
}

