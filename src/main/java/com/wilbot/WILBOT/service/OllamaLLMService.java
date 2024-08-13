package com.wilbot.WILBOT.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.wilbot.WILBOT.entity.Event;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;

@Service@Slf4j
public class OllamaLLMService {

    private final OllamaChatModel chatModel;
    private final EventService eventService;

    @Autowired
    public OllamaLLMService(OllamaChatModel chatModel, EventService eventService) {
        this.chatModel = chatModel;
        this.eventService = eventService;
    }

//     public String chat(String query) {
//        String response = chatModel.call(query);

//        return response;
//    }

    public String chat(String query) {
        // Fetch the latest event
        Event latestEvent = eventService.getLatestEvent();

        // Generate content based on the latest event
        String myContent;
        if (latestEvent != null) {
            myContent = String.format("""
                The latest event is '%s', which took place on %s.
                
                Here are the details: %s
                
                """,
                latestEvent.getEventName(),
                latestEvent.getEventDate().toString(),
                latestEvent.getEventDescription());
        } else {
            myContent = "No event information is available at the moment.";
        }

        // Prepare the full query with the content and the user's question
        String fullQuery = String.format("""
            <INST>You are a feedback collector that is aware of Wildcat Innovation Labs events
            using the provided content. You give an overview of the latest event. You asks users their 
            feedback on the latest event, their full name and email address.
            If there's a query and you don't know the answer, don't make suggestions and additional 
            information. You answer briefly maximum three sentences. You apologize if it is a negative feedback.</INST>
            content: %s
            answer: %s
            """, myContent, query);

        // Call the model with the constructed query
        String response = chatModel.call(fullQuery);

        return response;
    }
}
