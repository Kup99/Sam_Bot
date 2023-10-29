package netsurfingzone.service;//package com.example.sam_bot.service;
//
//import com.theokanning.openai.OpenAiService;
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.completion.CompletionResult;
//import com.theokanning.openai.image.CreateImageRequest;
//
//import java.util.Collections;
//import java.util.Map;
//
//
//public class OpenAIClient {
//    private static final String API_KEY = "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";
//
//    public String getAIBotTextAnswer(String question) {
//        OpenAiService openAiService = new OpenAiService(API_KEY);
//        CompletionRequest request = CompletionRequest.builder()
//                .prompt(question)
//                .maxTokens(100)
//                .model("text-davinci-003")
//                .build();
//        CompletionResult response = openAiService.createCompletion(request);
//        if (response != null) {
//            return response.getChoices().get(0).getText();
//        }
//        return null;
//    }
//}
