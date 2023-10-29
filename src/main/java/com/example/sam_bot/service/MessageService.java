package com.example.sam_bot.service;

import com.example.sam_bot.model.Message;
import com.example.sam_bot.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public void createMessage(Message message) {
        messageRepository.save(message);
    }
}
