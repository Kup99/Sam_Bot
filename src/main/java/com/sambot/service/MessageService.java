package com.sambot.service;

import com.sambot.MessageRepository;
import com.sambot.dto.Message;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
