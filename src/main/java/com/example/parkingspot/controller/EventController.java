package com.example.parkingspot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @PostMapping
  public ResponseEntity<Event> addNewEvent(@RequestBody Event event) {
    Event newEvent = eventService.registerNewEvent(event);
    if (newEvent.getId() != null) {
      return new ResponseEntity<Event>(newEvent, HttpStatus.CREATED);
    }
    return new ResponseEntity<Event>(newEvent, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
