package com.wspfeiffer.mfaserver.services.impl;

import com.theokanning.openai.OpenAiApi;

public class ChatGptServiceImpl implements ChatGptService{
    @Override
    public String processPrompt(String prompt) {
        var openAiApi = new OpenAiApi(System.getenv("OPENAI_API_KEY"));

        var chatClient = new OpenAiChatClient(openAiApi)
                .withDefaultOptions(OpenAiChatOptions.builder()
                        .withModel("gpt-35-turbo")
                        .withTemperature(0.4)
                        .withMaxTokens(200)
                        .build());

        ChatResponse response = chatClient.call(
                new Prompt("Generate the names of 5 famous pirates."));

// Or with streaming responses
        Flux<ChatResponse> response = chatClient.stream(
                new Prompt("Generate the names of 5 famous pirates."));
    }
}
