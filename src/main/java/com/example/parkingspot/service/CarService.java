package com.example.parkingspot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingspot.entity.Car;
import com.example.parkingspot.entity.Person;
import com.example.parkingspot.repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
public class CarService {
  private final CarRepository carRepository;
  private final PersonService personService;

  @Autowired
  public CarService(CarRepository carRepository, PersonService personService) {
    this.carRepository = carRepository;
    this.personService = personService;

  }

  public Car addNewCar(Car car) {
    Person owner = personService.getPersonById(car.getPersonId());
    Car newCar = new Car();
    newCar.setRegistration(car.getRegistration());
    newCar.setPerson(owner);
    return carRepository.save(newCar);
  }

  public List<Car> getCarsById(Long personId) {
    return carRepository.getAllCarsById(personId);
  }

  public Car getOneCarById(Long personId) {
    return carRepository.findById(personId).orElseThrow(() -> new RuntimeException("No car found"));
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  @Transactional
  public Car updateCarOwner(Long carId, Long newOwnerId) {
    Optional<Car> carOptional = carRepository.findById(carId);
    Person newOwner = personService.getPersonById(newOwnerId);
    if (carOptional.isPresent() && newOwner != null) {
      Car foundCar = carOptional.get();
      foundCar.setPerson(newOwner);
      return foundCar;
    }
    return null;
  }

}
