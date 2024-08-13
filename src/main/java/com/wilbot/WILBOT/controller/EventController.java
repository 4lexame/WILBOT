package com.wilbot.WILBOT.controller;

import com.wilbot.WILBOT.entity.Event;
import com.wilbot.WILBOT.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events/latest")
    public String showLatestEvent(Model model) {
        // Event latestEvent = eventService.getLatestEvent();
        // if (latestEvent == null) {
        //     System.out.println("No latest event found");
        // } else {
        //     System.out.println("Latest event found: " + latestEvent.getEventName());
        // }
        // model.addAttribute("latestEvent", latestEvent);
        return "index";
    }
}