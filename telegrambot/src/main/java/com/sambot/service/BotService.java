package com.sambot.service;

import com.currencyParser.grpc.CurrencyRate;
import com.sambot.config.BotConfiguration;
import com.sambot.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class BotService extends TelegramLongPollingBot {

    private KafkaProducer producer;

    @Autowired
    private CurrencyRateService currencyService;

    @Autowired
    public BotService(KafkaProducer producer) {
        this.producer = producer;
    }

    @Autowired
    BotConfiguration configuration;

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
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            getCurrencyPrice(messageText, chatId);
        }
    }

    private void getCurrencyPrice(String currency, long chatId) {
        LocalDate currentDate = LocalDate.now();
        Mono.just(currencyService.getCurrencyRateSync(currency, currentDate))
                .map(CurrencyRate.CurrencyRateResponse::getValue)
                .subscribe(
                        price -> sendMessage(chatId, "The price of " + currency.toUpperCase() + " on " + currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " is " + price),
                        error -> sendMessage(chatId, "Failed to get the price of " + currency.toUpperCase())
                );
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
