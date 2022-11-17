package com.example.parkingspot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspot.entity.Event;
import com.example.parkingspot.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

  private EventService eventService;

  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  @GetMapping
  public List<Event> getAllEvents() {
    return eventService.fetchAllEvents();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Event> getEventById(@PathVariable("id") Long eventId) {
    Event foundEvent = eventService.fetchEventById(eventId);
    if (foundEvent != null) {
      return ResponseEntity.ok().body(foundEvent);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Event> addNewEvent(@RequestBody Event event) {
    Event newEvent = eventService.registerNewEvent(event);
    if (newEvent.getId() != null) {
      return ResponseEntity.created(null).body(newEvent);
    }
    return ResponseEntity.internalServerError().body(newEvent);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Event> updateEventStopTime(@PathVariable("id") Long eventId,
      @RequestParam("stopTime") LocalDateTime stopTime) {
    Event event = eventService.setNewEventStopTime(eventId, stopTime);
    if (event.getId() != null) {
      return ResponseEntity.ok().body(event);
    }
    return ResponseEntity.notFound().build();
  }
}
