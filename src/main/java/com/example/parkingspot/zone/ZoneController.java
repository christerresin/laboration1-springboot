package com.example.parkingspot.zone;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

  @PostMapping
  public void addNewParkingZone(Zone zone) {

  }

}
