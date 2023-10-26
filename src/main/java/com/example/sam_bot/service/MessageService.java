package com.example.sam_bot.service;

import com.example.sam_bot.model.Message;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Service
public class MessageService {

    public void createMessage(Message message) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.execute("INSERT INTO messages VALUES ('Stella')");
    }
}
