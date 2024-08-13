package com.wilbot.WILBOT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wilbot.WILBOT.entity.Event;
import com.wilbot.WILBOT.service.EventService;

@Controller
public class PageController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String index(Model model) {
        Event latestEvent = eventService.getLatestEvent();
        if (latestEvent == null) {
            System.out.println("No latest event found");
        } else {
            System.out.println("Latest event found: " + latestEvent.getEventName());
        }
        model.addAttribute("latestEvent", latestEvent);
        return "index";
    }

    
}
