package com.example.parkingspot.car;

import com.example.parkingspot.person.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String registration;
  @Transient
  private Long personId;
  @ManyToOne
  private Person person;

  public Car() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegistration() {
    return registration;
  }

  public void setRegistrationNr(String registrationNr) {
    this.registration = registrationNr;
  }

  public void setRegistration(String registration) {
    this.registration = registration;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Long getPersonId() {
    return personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

}
