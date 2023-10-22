package com.example.sam_bot.service;

import com.example.sam_bot.model.Message;
import org.springframework.stereotype.Service;

public interface MessageService {
     void createMessage(Message message);
}
