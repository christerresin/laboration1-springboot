package com.example.parkingspot.zone;

import org.springframework.stereotype.Service;

@Service
public class ZoneService {
  private ZoneRepository zoneRepository;

  public ZoneService(ZoneRepository zoneRepository) {
    this.zoneRepository = zoneRepository;
  }

  public void registerNewParkingZone(Zone zone) {
    zoneRepository.save(zone);
  }
}
