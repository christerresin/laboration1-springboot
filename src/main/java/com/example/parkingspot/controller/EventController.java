package com.example.parkingspot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspot.entity.Event;
import com.example.parkingspot.service.CarService;
import com.example.parkingspot.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

  private CarService carService;
  private EventService eventService;

  public EventController(CarService carService, EventService eventService) {
    this.carService = carService;
    this.eventService = eventService;
  }

  @PostMapping
  public Event addNewEvent(@RequestBody Event event) {
    return eventService.registerNewEvent(event);
  }
}
