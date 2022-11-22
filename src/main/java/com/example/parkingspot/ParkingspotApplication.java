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

// Refactor zone to optionals

// Batch update active status?