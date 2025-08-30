package com.example.chatbot.repository;

import com.example.chatbot.model.Message;
import com.example.chatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(User sender);
    List<Message> findByReceiver(User receiver);
    List<Message> findBySenderAndReceiver(User sender, User receiver);
}
