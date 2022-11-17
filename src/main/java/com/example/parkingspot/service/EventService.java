package com.example.parkingspot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.parkingspot.entity.Car;
import com.example.parkingspot.entity.Event;
import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.repository.EventRepository;

@Service
public class EventService {

  private ZoneService zoneService;
  private EventRepository eventRepository;
  private CarService carService;

  public EventService(ZoneService zoneService, EventRepository eventRepository, CarService carService) {
    this.zoneService = zoneService;
    this.eventRepository = eventRepository;
    this.carService = carService;
  }

  public Event registerNewEvent(Event event) {
    // Optional<Zone> zoneOptional = zoneService.findZoneById(event.getZoneId());
    Optional<Zone> zoneOptional = zoneService.findZoneById(event.getZone().getId());
    if (zoneOptional.isPresent()) {
      event.setZone(zoneOptional.get());
    }

    // Optional<Car> carOptional = carService.findCarById(event.getCarId());
    // Optional<Car> carOptional = carService.findCarById(event.getCar().getId());
    Optional<Car> carOptional = carService.fetchCarByRegistration(event.getCar().getRegistration());
    if (carOptional.isPresent()) {
      event.setCar(carOptional.get());
    }
    try {
      eventRepository.save(event);
      return event;
    } catch (DataAccessException e) {
      return new Event();
    }
  }

  public List<Event> fetchAllEvents() {
    return eventRepository.findAll();
  }

  public Event fetchEventById(Long eventId) {
    Optional<Event> eventOptional = eventRepository.findById(eventId);
    if (eventOptional.isPresent()) {
      return eventOptional.get();
    }
    return null;
  }

}
