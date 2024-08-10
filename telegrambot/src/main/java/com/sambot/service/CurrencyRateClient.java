package com.sambot.service;

import com.example.proto.CurrencyRateProto;
import com.example.proto.CurrencyRateServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyRateClient {

    @GrpcClient("currencyRateParser")
    private final CurrencyRateServiceGrpc.CurrencyRateServiceBlockingStub blockingStub;

    public CurrencyRateClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        blockingStub = CurrencyRateServiceGrpc.newBlockingStub(channel);
    }

    public String getCurrencyRate(String currency, LocalDate date) {
        CurrencyRateProto.CurrencyRateRequest request = CurrencyRateProto.CurrencyRateRequest.newBuilder()
                .setCurrency(currency)
                .setDate(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .build();
        CurrencyRateProto.CurrencyRateResponse response = blockingStub.getCurrencyRate(request);
        return response.getValue();
    }
}