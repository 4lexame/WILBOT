package com.wilbot.WILBOT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wilbot.WILBOT.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e ORDER BY e.eventDate DESC")
    List<Event> findAllOrderedByEventDateDesc();

    @Query("SELECT e FROM Event e ORDER BY e.eventDate DESC")
    // Event findLatestEvent();
    default Event findLatestEvent() {
        List<Event> events = findAllOrderedByEventDateDesc();
        return events.isEmpty() ? null : events.get(0);
    }
}