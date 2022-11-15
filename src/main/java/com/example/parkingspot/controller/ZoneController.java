package com.example.parkingspot.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspot.entity.Zone;
import com.example.parkingspot.service.ZoneService;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
  private ZoneService zoneService;

  public ZoneController(ZoneService zoneService) {
    this.zoneService = zoneService;
  }

  @PostMapping
  public void addNewParkingZone(@RequestBody Zone zone) {
    zoneService.registerNewParkingZone(zone);
  }

  public ResponseEntity<Zone> getZoneById(Long zoneId) {
    Optional<Zone> zoneOptional = zoneService.findZoneById(zoneId);
    if (zoneOptional.isPresent()) {
      return new ResponseEntity<>(zoneOptional.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
