package com.example.parkingspot.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  @Query("SELECT c FROM Car c WHERE c.person.id = :personId")
  List<Car> getAllCarsById(@Param("personId") Long personId);
}
