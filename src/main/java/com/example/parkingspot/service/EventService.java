package com.example.parkingspot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.parkingspot.entity.Event;
import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.repository.EventRepository;

@Service
public class EventService {

  private ZoneService zoneService;
  private EventRepository eventRepository;

  public EventService(ZoneService zoneService, EventRepository eventRepository) {
    this.zoneService = zoneService;
    this.eventRepository = eventRepository;
  }

  public Event registerNewEvent(Event event) {
    Optional<Zone> zoneOptional = zoneService.findZoneById(event.getZoneId());
    if (zoneOptional.isPresent()) {
      event.setZone(zoneOptional.get());
    }
    return eventRepository.save(event);
  }

}
