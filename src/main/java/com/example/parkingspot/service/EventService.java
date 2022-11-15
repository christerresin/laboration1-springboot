package com.example.parkingspot.service;

import java.util.Optional;

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
    Optional<Zone> zoneOptional = zoneService.findZoneById(event.getZoneId());
    if (zoneOptional.isPresent()) {
      event.setZone(zoneOptional.get());
    }
    Optional<Car> carOptional = carService.findCarById(event.getCarId());
    if (carOptional.isPresent()) {
      event.setCar(carOptional.get());
    }
    return eventRepository.save(event);
  }

}
