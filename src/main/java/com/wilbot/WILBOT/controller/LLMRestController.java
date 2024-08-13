package com.wilbot.WILBOT.controller;

import com.wilbot.WILBOT.service.OllamaLLMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/chatbot")
public class LLMRestController {

    private final OllamaLLMService ollamaLLMService;

    public LLMRestController(OllamaLLMService ollamaLLMService) {
        this.ollamaLLMService = ollamaLLMService;
    }

    @PostMapping("/respond")
    public ResponseEntity<String> chat(@RequestBody String userQuery) {
        String chatResponse = ollamaLLMService.chat(userQuery);
        return ResponseEntity.ok(chatResponse);
    }

    @GetMapping("/start")
    public ResponseEntity<String> start() {
        return ResponseEntity.ok("Hi! I'm Wilbot. How can I help you today?");
    }

}
