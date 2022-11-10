package com.example.parkingspot.event;

import java.sql.Date;

import com.example.parkingspot.car.Car;
import com.example.parkingspot.zone.Zone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date start;
  private Date stop;
  private boolean active = true;
  @OneToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "car", referencedColumnName = "id")
  private Car car;
  @ManyToOne
  private Zone zone;

  @Transient
  private int car_id;
  @Transient
  private int zone_id;

  public Event() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getStop() {
    return stop;
  }

  public void setStop(Date stop) {
    this.stop = stop;
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

  public int getCar_id() {
    return car_id;
  }

  public void setCar_id(int car_id) {
    this.car_id = car_id;
  }

  public int getZone_id() {
    return zone_id;
  }

  public void setZone_id(int zone_id) {
    this.zone_id = zone_id;
  }

  public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

}
