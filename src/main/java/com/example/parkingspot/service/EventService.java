package com.example.parkingspot.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.parkingspot.entity.Car;
import com.example.parkingspot.entity.Event;
import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.repository.EventRepository;

import jakarta.transaction.Transactional;

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
    Optional<Zone> zoneOptional = zoneService.findZoneById(event.getZone().getId());
    if (zoneOptional.isPresent()) {
      event.setZone(zoneOptional.get());
    }

    Optional<Car> carOptional = carService.fetchCarByRegistration(event.getCar().getRegistration());
    if (carOptional.isPresent()) {
      event.setCar(carOptional.get());
    }

    event.setStart(LocalDateTime.now());

    if (!checkStopTimeIsAfterStart(event)) {
      return new Event();
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

  public Event setNewEventStopTime(Long eventId, LocalDateTime stopTime) {
    Optional<Event> event = eventRepository.findById(eventId);

    // NEST THESE IFs?!
    if (event.isPresent()) {
      event.get().setStop(stopTime);
    }

    if (checkStopTimeIsAfterStart(event.get()) && event.isPresent()) {
      eventRepository.save(event.get());
      return event.get();
    }

    return new Event();

  }

  private boolean checkStopTimeIsAfterStart(Event event) {
    LocalDateTime startTime = LocalDateTime.parse(String.valueOf(event.getStart()));
    LocalDateTime stopTime = LocalDateTime.parse(String.valueOf(event.getStop()));
    int diff = startTime.compareTo(stopTime);

    if (diff > 0) {
      return false;
    }

    return true;
  }

  private boolean checkStopTimeIsBeforeNow(Event event) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime stopTime = LocalDateTime.parse(String.valueOf(event.getStop()));
    int diff = now.compareTo(stopTime);

    if (diff < 0) {
      return false;
    }

    return true;
  }

  @Transactional
  public List<Event> fetchAllActiveEvents(boolean status) {
    List<Event> eventsList = eventRepository.findByActiveStatus(status);

    for (int i = 0; i < eventsList.size(); i++) {
      if (checkStopTimeIsBeforeNow(eventsList.get(i))) {
        Event currentEvent = eventsList.get(i);
        currentEvent.setActive(false);
        eventRepository.save(currentEvent);
        eventsList.remove(eventsList.get(i));
      }
    }

    if (eventsList.size() > 0) {

      return eventsList;
    }
    return null;
  }

}
