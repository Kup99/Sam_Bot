package com.sambot.service;

import com.currencyParser.grpc.CurrencyRate;
import com.currencyParser.grpc.CurrencyRateServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyRateService extends CurrencyRateServiceGrpc.CurrencyRateServiceImplBase {

    @Override
    public void getCurrencyRate(CurrencyRate.CurrencyRateRequest request,
                                StreamObserver<CurrencyRate.CurrencyRateResponse> responseObserver) {
        String currency = request.getCurrency();
        String date = request.getDate();

        // Ваша логика для получения курса валюты
        String value = getCurrencyValue(currency, date);

        CurrencyRate.CurrencyRateResponse response = CurrencyRate.CurrencyRateResponse.newBuilder()
                .setValue(value)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String getCurrencyValue(String currency, String date) {
        // Реализуйте логику получения курса валюты здесь
        return "100"; // Пример значения, замените на вашу логику
    }

    public CurrencyRate.CurrencyRateResponse getCurrencyRateSync(String currency, LocalDate date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        CurrencyRate.CurrencyRateRequest request = CurrencyRate.CurrencyRateRequest.newBuilder()
                .setCurrency(currency)
                .setDate(formattedDate)
                .build();

        // Создаем синхронный клиентский канал
        CurrencyRateServiceGrpc.CurrencyRateServiceBlockingStub stub = CurrencyRateServiceGrpc.newBlockingStub(
                io.grpc.ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build()
        );

        return stub.getCurrencyRate(request);
    }
}
