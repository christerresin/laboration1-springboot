package com.example.parkingspot.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;

  }

  @GetMapping
  public List<Car> getAllCars() {
    return carService.getAllCars();
  }

  @GetMapping("/{id}")
  public List<Car> getCarsByOwner(@PathVariable("id") Long personId) {
    // List<Long> carpersonId = Arrays.asList(personId);
    return carService.getCarsById(personId);
  }

  // @GetMapping("/car")
  // public Car getOwnersCar(@PathVariable("id") Long ownerId) {
  // return carService.getOneCarById(ownerId);
  // }

  @PostMapping
  public void registerNewCar(@RequestBody Car car) {
    carService.addNewCar(car);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Car> changeOwner(@PathVariable("id") Long carId,
      @RequestParam(required = true) Long newOwnerId) {
    Car foundCar = carService.updateCarOwner(carId, newOwnerId);
    if (foundCar != null) {
      return new ResponseEntity<>(foundCar, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
