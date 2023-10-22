package com.example.sam_bot.service;

import com.example.sam_bot.model.Message;
import com.example.sam_bot.repository.MessageRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MessageServiceImpl implements MessageService {

    MessageRepository repository;

    @Override
    public void createMessage(Message message) {
        repository.save(message);
    }
}
