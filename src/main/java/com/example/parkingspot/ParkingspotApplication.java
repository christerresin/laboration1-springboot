package com.example.parkingspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingspotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingspotApplication.class, args);
	}

}
// TODO
// Refactor querys in carRepo class
// Save new person upon event creation if not present in DB
// Save new car upon event creation if not present in DB
// Custom query for active/inactive parkings

// Refactor zone to optionals
// Hibernate.initialize() - to not use EAGER as FetchType.
// Load data before view/serilization

// LOGIC FOR ACTIVE PARKINGS
// fetch all active = true
// check stop > now
// if stop < now (active = false)