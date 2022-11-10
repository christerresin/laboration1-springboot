package com.example.parkingspot.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
  private final CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public void addNewCar(Car car) {
    carRepository.save(car);
  }

  public List<Car> getCarsById(Long ownerId) {
    return carRepository.findAllById(ownerId).orElseThrow(() -> new RuntimeException("not found"));
  }

  public Car getOneCarById(Long ownerId) {
    return carRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("No car found"));
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

}
