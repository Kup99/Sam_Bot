package ru.cbrrate.services;

//import com.example.grpc.CurrencyRateProto;
//import com.example.grpc.CurrencyRateServiceGrpc;
//import io.grpc.stub.StreamObserver;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CurrencyRateServiceImpl extends CurrencyRateServiceGrpc.CurrencyRateServiceImplBase {
//
//    @Override
//    public void getCurrencyRate(CurrencyRateProto.CurrencyRateRequest request,
//                                StreamObserver<CurrencyRateProto.CurrencyRateResponse> responseObserver) {
//        String currency = request.getCurrency();
//        String date = request.getDate();
//
//        // Ваша логика для получения курса валюты
//        String value = getCurrencyValue(currency, date); // Реализуйте этот метод
//
//        CurrencyRateProto.CurrencyRateResponse response = CurrencyRateProto.CurrencyRateResponse.newBuilder()
//                .setValue(value)
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }

//    private String getCurrencyValue(String currency, String date) {
//        // Реализуйте логику получения курса валюты здесь
//        return "100"; // Пример значения, замените на вашу логику
//    }
//}
