package com.example.parkingspot.event;

import java.util.List;

import org.springframework.data.geo.Polygon;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Polygon location;
  private String name;
  @OneToMany(mappedBy = "id", cascade = CascadeType.DETACH)
  private List<Event> events;

  public Zone() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Polygon getLocation() {
    return location;
  }

  public void setLocation(Polygon location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
