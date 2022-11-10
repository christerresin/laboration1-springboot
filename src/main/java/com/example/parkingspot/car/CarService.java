package com.example.parkingspot.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingspot.person.Person;
import com.example.parkingspot.person.PersonController;

@Service
public class CarService {
  private final CarRepository carRepository;
  private final PersonController personController;

  @Autowired
  public CarService(CarRepository carRepository, PersonController personController) {
    this.carRepository = carRepository;
    this.personController = personController;

  }

  public void addNewCar(Car car) {
    Person owner = personController.getPerson(car.getPersonId());
    Car newCar = new Car();
    newCar.setRegistration(car.getRegistration());
    newCar.setPerson(owner);
    carRepository.save(newCar);
  }

  public List<Car> getCarsById(List<Long> personId) {
    List<Car> carResponse = (List<Car>) carRepository.findAllById(personId);
    return carResponse;
  }

  public Car getOneCarById(Long personId) {
    return carRepository.findById(personId).orElseThrow(() -> new RuntimeException("No car found"));
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

}
