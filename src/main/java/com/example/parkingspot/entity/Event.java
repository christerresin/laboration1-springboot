package com.example.parkingspot.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private LocalDateTime start;
  @UpdateTimestamp
  private LocalDateTime stop;
  private boolean active = true;
  @ManyToOne
  private Car car;
  @ManyToOne
  private Zone zone;
  @Transient
  private Long carId;
  @Transient
  private Long zoneId;

  public Event() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public Long getZoneId() {
    return zoneId;
  }

  public void setZoneId(Long zoneId) {
    this.zoneId = zoneId;
  }

  public LocalDateTime getStart() {
    return start;
  }

  public void setStart(LocalDateTime start) {
    this.start = start;
  }

  public LocalDateTime getStop() {
    return stop;
  }

  public void setStop(LocalDateTime stop) {
    this.stop = stop;
  }

}
