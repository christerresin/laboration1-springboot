package com.example.parkingspot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.repository.ZoneRepository;

@Service
public class ZoneService {
  private ZoneRepository zoneRepository;

  public ZoneService(ZoneRepository zoneRepository) {
    this.zoneRepository = zoneRepository;
  }

  public void registerNewParkingZone(Zone zone) {
    zoneRepository.save(zone);
  }

  public Optional<Zone> findZoneById(Long zoneId) {
    return zoneRepository.findById(zoneId);
  }
}