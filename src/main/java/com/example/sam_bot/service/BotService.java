package com.example.sam_bot.service;

import com.example.sam_bot.config.BotConfiguration;

import com.example.sam_bot.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service
@AllArgsConstructor
public class BotService extends TelegramLongPollingBot {
    private final BotConfiguration configuration;

    @Autowired
    MessageService messageService;

    @Override
    public String getBotUsername() {
        return configuration.getBotName();
    }

    @Override
    public String getBotToken() {
        return configuration.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update != null && update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            //OpenAIClient openAIClient = new OpenAIClient();
            //long chatId = update.getMessage().getChatId();
           // String aiAnswer = openAIClient.getAIBotTextAnswer(messageText);
            //startCommandReceive(chatId,"SomeText");
            saveMessage(messageText);
        }
    }

    private void saveMessage(String message){
//        messageService.createMessage(new Message(message));
    }

    private void startCommandReceive(long chatId, String answer) {
        //sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendVideo(long chatId, String link) {
        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(chatId);
        try {
            putVideoToResource(link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sendVideo.setVideo(new InputFile(new File("src/main/resources/" + link)));
        try {
            execute(sendVideo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendPhoto(long chatId, String link) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(link)));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void putVideoToResource(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(new File(urlStr));
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
