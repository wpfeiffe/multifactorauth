package com.wspfeiffer.mfaserver.resource;

import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.llm.OpenAiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chatgpt")
public class ChatgptResource {

     


    @GetMapping()
    public Completion completion(@RequestParam (value = "prompt") String prompt) {
        return new Completion("Bills Completion");
    }
}
