package com.example.parkingspot.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/cars")
  public List<Car> getAllCars() {
    return carService.getAllCars();
  }

  @GetMapping("/cars/{id}")
  public List<Car> getCarsByOwner(@PathVariable("id") Long ownerId) {
    return carService.getCarsById(ownerId);
  }

  @GetMapping("/car")
  public Car getOwnersCar(@PathVariable("id") Long ownerId) {
    return carService.getOneCarById(ownerId);
  }

  @PostMapping
  public void registerNewCar(@RequestBody Car car) {
    carService.addNewCar(car);
  }

}
