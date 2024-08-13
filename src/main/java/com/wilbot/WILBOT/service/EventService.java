package com.wilbot.WILBOT.service;

import com.wilbot.WILBOT.entity.Event;
import com.wilbot.WILBOT.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event getLatestEvent() {
        return eventRepository.findLatestEvent();
    }
}
